FROM golang:1.22-alpine AS builder
LABEL authors="ivlev"
WORKDIR /build

COPY go.mod go.sum ./

RUN go mod download

COPY . .

RUN go build -o /build/bin/JobService ./cmd/job/main.go

FROM alpine:latest

WORKDIR /

COPY --from=builder /build/bin/JobService /JobService
COPY --from=builder /build/configs/config.yml /configs/config.yml

EXPOSE 5000

ENTRYPOINT ["/JobService"]