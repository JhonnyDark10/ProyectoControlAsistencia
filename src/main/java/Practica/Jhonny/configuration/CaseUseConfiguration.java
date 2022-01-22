package Practica.Jhonny.configuration;

import Practica.Jhonny.caseuse.GetUser;
import Practica.Jhonny.caseuse.GetUserImplement;
import Practica.Jhonny.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
