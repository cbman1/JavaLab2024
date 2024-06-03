package config

import (
	"fmt"
	"gopkg.in/yaml.v3"
	"io/ioutil"
	"os"
)

type Config struct {
	Mongo MongoConfig `yaml:"mongo"`
	GRPC  GRPCConfig  `yaml:"grpc"`
}

type MongoConfig struct {
	Database MongoDatabaseConfig `yaml:"database"`
}

type MongoDatabaseConfig struct {
	Name string `yaml:"name"`
	URI  string `yaml:"uri"`
}

type GRPCConfig struct {
	Host string `yaml:"host"`
	Port string `yaml:"port"`
}

func Parse() (*Config, error) {
	cfgPath := os.Getenv("CONFIG_PATH")
	if cfgPath == "" {
		return nil, fmt.Errorf("CONFIG_PATH environment variable not set")
	}

	if _, err := os.Stat(cfgPath); os.IsNotExist(err) {
		return nil, fmt.Errorf("config file does not exist: %w", err)
	}

	fileContent, err := ioutil.ReadFile(cfgPath)
	if err != nil {
		return nil, fmt.Errorf("read config file: %w", err)
	}

	var cfg Config

	if err := yaml.Unmarshal(fileContent, &cfg); err != nil {
		return nil, fmt.Errorf("unmarshal config file: %w", err)
	}

	return &cfg, nil
}
