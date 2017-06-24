#!/usr/bin/env bash

set -e

./gradlew generateLock saveLock
./gradlew test check
./gradlew commitLock
