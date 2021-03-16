#!/bin/bash

echo "************Building docker image************"
docker build . -t devhaus-assignment:latest

wait

echo "************Run the docker Image************"
docker run -t devhaus-assignment:latest