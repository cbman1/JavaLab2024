FROM golang:1.22-alpine as builder
LABEL authors="ivlev"

WORKDIR /build

COPY . .

RUN go mod download

RUN go build -o ./bin/CvService ./cmd/cv/main.go

FROM alpine
COPY --from=builder /build/bin/CvService /CvService
COPY --from=builder /build/configs/config.yml /configs/config.yml

EXPOSE 5001

ENTRYPOINT ["/CvService"]

ENTRYPOINT ["top", "-b"]