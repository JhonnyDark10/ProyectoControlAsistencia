package Practica.Jhonny;

import Practica.Jhonny.been.MyBean;
import Practica.Jhonny.been.MyBeanImplement;
import Practica.Jhonny.been.MyBeanWithDependency;
import Practica.Jhonny.been.MybeanWithProperties;
import Practica.Jhonny.component.ComponentDependency;
import Practica.Jhonny.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JhonnyApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
    private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;
	private MybeanWithProperties mybeanWithProperties;
	private UserPojo userPojo;

	private final Log LOGGER = LogFactory.getLog(JhonnyApplication.class);
	//crear constructor
	public JhonnyApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency , MyBean myBean,MyBeanWithDependency myBeanWithDependency, MybeanWithProperties mybeanWithProperties, UserPojo userPojo){
	this.componentDependency = componentDependency;
	this.myBean =myBean;
	this.myBeanWithDependency = myBeanWithDependency;
	this.mybeanWithProperties = mybeanWithProperties;
	this.userPojo = userPojo;
	}



	public static void main(String[] args) {
		SpringApplication.run(JhonnyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ejemplosAnteriores();



	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(mybeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
		LOGGER.error("esto es un error");
	}
}
