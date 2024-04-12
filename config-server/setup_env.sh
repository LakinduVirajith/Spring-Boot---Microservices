#!/bin/bash

# Display Department service yaml with passwords
echo "Department Service YAML with passwords:"
cat src/main/resources/config/department-service.yaml

# Display Employee service yaml with passwords
echo "Employee Service YAML with passwords:"
cat src/main/resources/config/employee-service.yaml

# Replace placeholders in Department service yaml
sed -i "s/\${MONGODB_USERNAME}/$MONGODB_USERNAME/g" src/main/resources/config/department-service.yaml
sed -i "s/\${MONGODB_PASSWORD}/$MONGODB_PASSWORD/g" src/main/resources/config/department-service.yaml

# Replace placeholders in Employee service yaml
sed -i "s/\${MONGODB_USERNAME}/$MONGODB_USERNAME/g" src/main/resources/config/employee-service.yaml
sed -i "s/\${MONGODB_PASSWORD}/$MONGODB_PASSWORD/g" src/main/resources/config/employee-service.yaml

# Display Department service yaml with passwords
echo "Department Service YAML with passwords:"
cat src/main/resources/config/department-service.yaml

# Display Employee service yaml with passwords
echo "Employee Service YAML with passwords:"
cat src/main/resources/config/employee-service.yaml
