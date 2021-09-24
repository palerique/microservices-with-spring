#!/usr/bin/env bash
set -x
set -e

pushd docker-compose || exit
docker compose down
popd || exit
