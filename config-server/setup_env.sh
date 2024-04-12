#!/bin/bash

# Replace placeholders in Employee service yaml
sed -i "s/\${MONGODB_USERNAME}/$MONGODB_USERNAME/g" src/main/resources/config/employee-service.yaml
sed -i "s/\${MONGODB_PASSWORD}/$MONGODB_PASSWORD/g" src/main/resources/config/employee-service.yaml
