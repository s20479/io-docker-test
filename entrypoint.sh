#!/bin/sh

docker build -f ./docker/Dockerfile -t pjatk/io_backend:latest .
docker-compose -f ./docker/docker-compose.yml down && docker-compose -f ./docker/docker-compose.yml up