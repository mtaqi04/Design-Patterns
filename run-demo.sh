#!/usr/bin/env bash
set -e
mkdir -p data
[ -f data/brandA_bulb.txt ] || echo "9" > data/brandA_bulb.txt
[ -f data/brandB_lock.txt ] || echo "battery=150" > data/brandB_lock.txt
mvn -q -DskipTests package
java -cp target/classes com.assignment.dp.Demo
