#!/usr/bin/env bash
docker run -it --rm -v "$HOME/.m2":/root/.m2 -v "$(pwd)":/usr/src/myapp -w /usr/src/myapp openjdk:11 ./mvnw package -Dmaven.test.skip=true