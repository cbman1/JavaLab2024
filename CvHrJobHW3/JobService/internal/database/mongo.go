package database

import (
	"JobService/internal/config"
	"context"
	"fmt"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

func SetupMongoDatabase(ctx context.Context, cfg *config.MongoConfig) (*mongo.Database, error) {
	clientOpts := options.Client().ApplyURI(cfg.Database.URI)
	client, err := mongo.Connect(ctx, clientOpts)
	if err != nil {
		return nil, fmt.Errorf("connect to mongo db: %w", err)
	}

	if err := client.Ping(ctx, nil); err != nil {
		return nil, fmt.Errorf("ping mongo db: %w", err)
	}

	db := client.Database(cfg.Database.Name)
	return db, nil
}
