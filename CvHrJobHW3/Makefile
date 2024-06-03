.PHONY: all clean generate

PROTO_SRC=proto/cv.proto
PROTO_FILES=proto/cv.pb.go proto/cv_grpc.pb.go

all: generate

clean:
	rm -f $(PROTO_FILES)

generate: clean
	protoc --go_out=. --go-grpc_out=. $(PROTO_SRC)