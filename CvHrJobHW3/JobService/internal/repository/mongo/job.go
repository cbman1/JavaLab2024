package mongo

import (
	"JobService/internal/core"
	"context"
	"fmt"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"time"
)

type JobRepository struct {
	collection *mongo.Collection
}

func NewJobRepository(collection *mongo.Collection) *JobRepository {
	return &JobRepository{collection: collection}
}

func (repository *JobRepository) GetAll(ctx context.Context) ([]*core.Job, error) {
	ctxTimeout, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	jobChannel := make(chan []*core.Job)
	errChannel := make(chan error)

	go func() {
		jobs, err := repository.retrieveJobs(ctxTimeout)
		if err != nil {
			errChannel <- err
		} else {
			jobChannel <- jobs
		}
		close(errChannel)
		close(jobChannel)
	}()

	select {
	case <-ctxTimeout.Done():
		return nil, fmt.Errorf("processing timeout in Mongo")
	case jobs := <-jobChannel:
		return jobs, nil
	case err := <-errChannel:
		return nil, fmt.Errorf("processing error in Mongo: %w", err)
	}
}

func (repository *JobRepository) retrieveJobs(ctx context.Context) ([]*core.Job, error) {
	cur, err := repository.collection.Find(ctx, bson.M{})
	if err != nil {
		return nil, fmt.Errorf("retrieve jobs from Mongo: %w", err)
	}

	var jobs []*core.Job
	if err := cur.All(ctx, &jobs); err != nil {
		return nil, fmt.Errorf("processing all jobs in Mongo: %w", err)
	}

	return jobs, nil
}
