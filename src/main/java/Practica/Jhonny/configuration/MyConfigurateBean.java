package Practica.Jhonny.configuration;

import Practica.Jhonny.been.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurateBean {
    @Bean
    public MyBean beanOperation()
    {
    return new MyBeanImplement2();
    }

    @Bean
    public MyOperation beanOperationOperation()
    {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation)
    {
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
