package service

import (
	"CvHrJobHW3/CvService/internal/core"
	"CvHrJobHW3/CvService/proto"
	"context"
	"fmt"
)

type CVRepository interface {
	GetAll(ctx context.Context) ([]*core.CV, error)
}

type CVService struct {
	proto.CVServiceServer
	cvRepository CVRepository
}

// NewCVService создаёт новый экземпляр CVService
func NewCVService(cvRepository CVRepository) *CVService {
	return &CVService{cvRepository: cvRepository}
}

// GetAll обрабатывает запрос на получение всех CV
func (s *CVService) GetAll(ctx context.Context, _ *proto.GetAllRequest) (*proto.GetAllResponse, error) {
	// Получение всех CV из репозитория
	cvs, err := s.cvRepository.GetAll(ctx)
	if err != nil {
		return nil, fmt.Errorf("get all CVs in service: %w", err)
	}

	// Если CV нет, создаем пустой список
	if cvs == nil {
		cvs = make([]*core.CV, 0)
	}

	// Преобразование core.CV в proto.CVResponse
	cvResponses := make([]*proto.CVResponse, len(cvs))
	for i, cv := range cvs {
		cvResponses[i] = &proto.CVResponse{
			FirstName:  cv.FirstName,
			LastName:   cv.LastName,
			Profession: cv.Profession,
			Experience: cv.Experience,
			City:       cv.City,
			Stack:      cv.Stack,
			Links:      cv.Links,
			Companies:  cv.Companies,
		}
	}

	// Возвращение ответа с преобразованными данными
	return &proto.GetAllResponse{
		Cvs: cvResponses,
	}, nil
}
