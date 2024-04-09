package com.springboot.departmentservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "CTSE Assignment Backend API Documentation",
                description = "This API documentation provides detailed information about the CTSE Assignment Backend. It includes endpoints, request and response models, and usage instructions.",
                version = "1.0"
        )
)
public class OpenApiConfig {
}
