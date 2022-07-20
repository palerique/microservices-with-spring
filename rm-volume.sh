#!/usr/bin/env bash
set -x
set -e

docker volume rm docker-compose_prom_data docker-compose_pushgateway_data
