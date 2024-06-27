package com.invoice.swagger.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "API INVOICES",
                description = "Billing system for multi-branch companies, with different integrated payment systems, purchasing, sales, reports and inventory modules",
                termsOfService = "https://trycatchfactory.com/terminos_y_condiciones",
                version = "1.0.0",
                contact = @Contact(
                        name = "Orlibeth Dun ",
                        url = "https://trycatchfactory.com",
                        email = "orlibet@trycatchfactory.com"
                ),
                license = @License(
                        name = "Standard Software Use License Comercial for Trycatchfactory",
                        url = "https://trycatchfactory.com/licence"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://trycatchfactory:8080/invoice"
                )
        },
        security = @SecurityRequirement(
                name = "Security Token"
        )
)
/*Active after implements security
@SecurityScheme(
        name = "Security Token",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)*/
public class Config {

}
