package core

import "go.mongodb.org/mongo-driver/bson/primitive"

type Job struct {
	ID          primitive.ObjectID `bson:"_id,omitempty" json:"id"`
	Company     string             `bson:"company,omitempty" json:"company"`
	Name        string             `bson:"name,omitempty" json:"name"`
	Description string             `bson:"description,omitempty" json:"description"`
	Stack       []string           `bson:"stack,omitempty" json:"stack"`
	Experience  int32              `bson:"experience,omitempty" json:"experience"`
	Salary      float32            `bson:"salary,omitempty" json:"salary"`
}
