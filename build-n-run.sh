#!/usr/bin/env bash
set -x
set -e

./build.sh
./build-docker.sh

#Run the compose
pushd docker-compose || exit
docker-compose up -d
popd || exit

./docker-compose-log.sh
