#!/usr/bin/env bash
set -x
set -e

pushd social-rating-data-collector || exit
docker build --build-arg JAR_FILE=build/libs/\*.jar -t palerique/social-rating-data-collector -f src/main/docker/Dockerfile .
popd || exit

pushd social-rating-calculator || exit
docker build --build-arg JAR_FILE=build/libs/\*.jar -t palerique/social-rating-calculator -f src/main/docker/Dockerfile .
popd || exit

pushd application-gateway || exit
docker build --build-arg JAR_FILE=build/libs/\*.jar -t palerique/social-rating-application-gateway -f src/main/docker/Dockerfile .
popd || exit


pushd application-config-server || exit
docker build --build-arg JAR_FILE=build/libs/\*.jar -t palerique/social-rating-application-config-server -f src/main/docker/Dockerfile .
popd || exit
