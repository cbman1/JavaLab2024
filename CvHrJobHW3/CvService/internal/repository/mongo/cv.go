package mongo

import (
	"CvHrJobHW3/CvService/internal/core"
	"context"
	"fmt"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"time"
)

type CVRepository struct {
	collection *mongo.Collection
}

func NewCVRepository(collection *mongo.Collection) *CVRepository {
	return &CVRepository{collection: collection}
}

func (repository *CVRepository) GetAll(ctx context.Context) ([]*core.CV, error) {
	ctxTimeout, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	CVChannel := make(chan []*core.CV)
	errChannel := make(chan error)

	go func() {
		errChannel <- repository.retrieveUsers(ctxTimeout, CVChannel)
		close(errChannel)
	}()

	var CVs []*core.CV
	select {
	case <-ctxTimeout.Done():
		fmt.Println("Processing timeout in Mongo")
		break
	case CVs = <-CVChannel:
		fmt.Println("Finished processing in Mongo")
	case err := <-errChannel:
		fmt.Println("Processing error in Mongo")
		return nil, err
	}

	return CVs, nil
}

func (repository *CVRepository) retrieveUsers(ctx context.Context, channel chan<- []*core.CV) error {
	cur, err := repository.collection.Find(ctx, bson.M{})
	if err != nil {
		return fmt.Errorf("retrieve CV from Mongo: %w", err)
	}

	var res []*core.CV
	if err := cur.All(ctx, &res); err != nil {
		return fmt.Errorf("processing all CVs in Mongo: %w", err)
	}

	channel <- res
	close(channel)

	return nil
}
