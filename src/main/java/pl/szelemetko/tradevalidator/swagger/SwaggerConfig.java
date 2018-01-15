package pl.szelemetko.tradevalidator.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())      
          .build()
          .apiInfo(info());                                           
    }
    
    private ApiInfo info() {
        return new ApiInfoBuilder()
                .title("Trade Validator Demo")
                .description("recruitment project, a simple app for validating trades")
                .version("1.0")
                .contact(new Contact("Andrzej Szelemetko", "https://github.com/Szelemetko", "a.szelemetko@gmail.com"))
                .build();
    }
}
