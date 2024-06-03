package database

import (
	"CvHrJobHW3/CvService/internal/config"
	"context"
	"fmt"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

func SetupMongoDatabase(ctx context.Context, cfg *config.MongoConfig) (*mongo.Database, error) {
	client, err := mongo.Connect(ctx, options.Client().ApplyURI(cfg.Database.URI))
	if err != nil {
		return nil, fmt.Errorf("connect to mongo db: %w", err)
	}

	if err := client.Ping(ctx, nil); err != nil {
		return nil, fmt.Errorf("ping mongo db: %w", err)
	}

	return client.Database(cfg.Database.Name), nil
}
