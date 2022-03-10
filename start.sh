#!/bin/sh

while ! nc -z database 3306
do
  sleep 2
done

java -jar app.jar