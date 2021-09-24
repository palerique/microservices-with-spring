#!/usr/bin/env bash
set -x
set -e

pushd gatling || exit
./gradlew clean gatlingRun
popd || exit
