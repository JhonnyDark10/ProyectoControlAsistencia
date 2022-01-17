package Practica.Jhonny.component;


import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{

@Override
    public void saludar(){
    System.out.println("hola mundo desde mi component dos");
}

}
