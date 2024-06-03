package grpc

import (
	"JobService/internal/config"
	"JobService/internal/service"
	"JobService/proto"
	"fmt"
	"google.golang.org/grpc"
	"net"
)

func ServeGRPC(cfg *config.GRPCConfig, jobService *service.JobService) error {
	addr := fmt.Sprintf("%s:%s", cfg.Host, cfg.Port)
	lis, err := net.Listen("tcp", addr)
	if err != nil {
		return fmt.Errorf("start tcp listener: %w", err)
	}

	grpcServer := grpc.NewServer()
	proto.RegisterJobServiceServer(grpcServer, jobService)

	go func() {
		if err := grpcServer.Serve(lis); err != nil {
			panic(fmt.Sprintf("failed to serve: %v", err))
		}
	}()

	return nil
}
