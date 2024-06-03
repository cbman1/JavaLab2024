package application

import (
	"CvHrJobHW3/CvService/internal/config"
	"CvHrJobHW3/CvService/internal/database"
	"CvService/internal/repository/mongo"
	"CvService/internal/service"
	server "CvService/internal/transport/grpc"
	"context"
	"fmt"
	"log"
)

func Run(ctx context.Context) error {
	cfg, err := config.Parse()
	if err != nil {
		return fmt.Errorf("build config: %w", err)
	}

	mongoDatabase, err := database.SetupMongoDatabase(ctx, &cfg.Mongo)
	if err != nil {
		return fmt.Errorf("start mongo connection: %w", err)
	}

	cvRepository := mongo.NewCVRepository(mongoDatabase.Collection("cvs"))

	cvService := service.NewCVService(cvRepository)
	if err := server.ServeGRPC(&cfg.GRPC, cvService); err != nil {
		return fmt.Errorf("start gRPC server: %w", err)
	}
	log.Printf("gRPC started at %v\n", cfg.GRPC.Port)

	<-ctx.Done()
	log.Println("gRPC server shutting down")

	return nil
}
