#!/usr/bin/env bash
set -x
set -e

pushd docker-compose || exit
docker-compose up -d --scale social-rating-calculator=5 --scale social-rating-data-collector=5 --no-recreate
popd || exit
