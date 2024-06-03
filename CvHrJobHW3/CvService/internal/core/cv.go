package core

import "go.mongodb.org/mongo-driver/bson/primitive"

type CV struct {
	ID         primitive.ObjectID `bson:"_id,omitempty" json:"id"`
	FirstName  string             `bson:"first-name,omitempty" json:"first_name"`
	LastName   string             `bson:"last-name,omitempty" json:"last_name"`
	Profession string             `bson:"profession,omitempty" json:"profession"`
	City       string             `bson:"city,omitempty" json:"city"`
	Experience int32              `bson:"experience,omitempty" json:"experience"`
	Stack      []string           `bson:"stack,omitempty" json:"stack"`
	Links      []string           `bson:"links,omitempty" json:"links"`
	Companies  []string           `bson:"companies,omitempty" json:"companies"`
}
