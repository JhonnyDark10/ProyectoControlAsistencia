package Practica.Jhonny.configuration;

import Practica.Jhonny.been.MybeanWithProperties;
import Practica.Jhonny.been.MybeanWithPropertiesImplement;
import Practica.Jhonny.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:conection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcurl;
    @Value("${driver}")
    private String driver;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;


    @Bean
    public MybeanWithProperties function(){
       return new MybeanWithPropertiesImplement(name,apellido);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcurl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);

        return dataSourceBuilder.build();
    }
}
