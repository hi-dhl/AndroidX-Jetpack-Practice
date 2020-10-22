#!/bin/sh

protoc --java_out=./src/main/java -I=./src/main/proto  ./src/main/proto/*.proto