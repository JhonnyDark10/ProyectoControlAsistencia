package Practica.Jhonny.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{


    @Override
    public void saludar() {
        System.out.println("mi primer hola mundo desde component");
    }
}
