#!/usr/bin/env bash
set -x
set -e

#pushd social-rating-data-collector || exit
#./gradlew clean check bootJar
#popd || exit
#
#pushd application-gateway || exit
#./gradlew clean check bootJar
#popd || exit
#
#pushd social-rating-calculator || exit
#./gradlew clean check bootJar
#popd || exit

#./gradlew clean check bootJar --debug
./gradlew clean check bootJar
