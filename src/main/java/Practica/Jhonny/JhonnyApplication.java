package Practica.Jhonny;

import Practica.Jhonny.been.MyBean;
import Practica.Jhonny.been.MyBeanImplement;
import Practica.Jhonny.been.MyBeanWithDependency;
import Practica.Jhonny.been.MybeanWithProperties;
import Practica.Jhonny.component.ComponentDependency;
import Practica.Jhonny.entity.User;
import Practica.Jhonny.pojo.UserPojo;
import Practica.Jhonny.repository.UserRepository;
import Practica.Jhonny.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JhonnyApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
    private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;
	private MybeanWithProperties mybeanWithProperties;
	private UserPojo userPojo;

	private final Log LOGGER = LogFactory.getLog(JhonnyApplication.class);
	private UserService userService;
	private UserRepository userRepository;


	//crear constructor
	public JhonnyApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency , MyBean myBean,MyBeanWithDependency myBeanWithDependency, MybeanWithProperties mybeanWithProperties, UserPojo userPojo,UserRepository userRepository,UserService userService){
	this.componentDependency = componentDependency;
	this.myBean =myBean;
	this.myBeanWithDependency = myBeanWithDependency;
	this.mybeanWithProperties = mybeanWithProperties;
	this.userPojo = userPojo;
	this.userRepository= userRepository;
	this.userService = userService;
	}

	private void saveWithErrorTransactional(){
		User test1 = new User("Test1Transactional1", "TestTransactional1@hotmail.com",LocalDate.now());
		User test2 = new User("Test2Transactional1", "TestTransactional1@hotmail.com",LocalDate.now());
		User test3 = new User("Test3Transactional1", "TestTransactional1@hotmail.com",LocalDate.now());
		User test4 = new User("Test4Transactional1", "TestTransactional1@hotmail.com",LocalDate.now());

		List<User> users = Arrays.asList(test1,test2,test3,test4);

		try{
			userService.saveTransactional(users);
		}catch (Exception e){
			LOGGER.error("esta es una exception dentro del metodo transaccional" +e);
		}


		userService.getAllUsers().stream().forEach(user->LOGGER.info("este usuario dentro del metodo transaccional "+ user));
	}

	public static void main(String[] args) {
		SpringApplication.run(JhonnyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUserInDataBase();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();

	}
	private void getInformationJpqlFromUser(){


	/*	LOGGER.info("usuario con el metodo finduserbyemail" + userRepository.findByUserEmail("piojo@outlook.es").orElseThrow(()-> new RuntimeException("no se encontro el usuario")));

	userRepository.findAndSort("fe", Sort.by("id").descending()).stream().forEach(user ->LOGGER.info("usuario con el metodo sort" + user));

	userRepository.findByName("pedro").stream()
				.forEach(user->LOGGER.info("Usuario con metodo query " + user));


	userRepository.findByNameLike("%y%").stream()
			.forEach(user-> LOGGER.info("suario con metodo query findByNameLike" + user));

		userRepository.findByNameOrEmail(null, "piojo@outlook.es").stream()
				.forEach(user-> LOGGER.info("suario con metodo query findByNameOrEmail" + user));*/

		userRepository.findByBirthDateBetween(LocalDate.of(2021, 3, 1),LocalDate.of(2022, 4,2 )
		).stream().forEach(user -> LOGGER.info("USUARIO CON INTERVALO DE FECHA" + user));

		userRepository.findByNameLikeOrderByIdDesc("%bricny%")
				.stream().forEach(user->LOGGER.info("usuario encontrado con like y ordenado" + user));


		userRepository.findByNameContainingOrderByIdDesc ("bricny")
				.stream().forEach(user->LOGGER.info("usuario encontrado con containg y ordenado" + user));


		LOGGER.info("el usuario apartir del parametro es: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021,03,20),
						"florghes@outlook.es")
				.orElseThrow(()->
						new RuntimeException("no se encontro el usuario a partir del 2022")));

	}


	private void saveUserInDataBase(){
		User user1 = new User("jhonny","florghes@outlook.es", LocalDate.of(2021,03,20));
		User user2 = new User("tame","piojo@outlook.es", LocalDate.of(2022,01,20));
		User user3 = new User("juan","flofgres@outlook.es", LocalDate.of(2021,03,20));
		User user4 = new User("enrique","flovcbres@outlook.es", LocalDate.of(2021,03,20));
		User user5 = new User("pedro","flvbcxores@outlook.es", LocalDate.of(2021,03,20));
		User user6 = new User("felipe","flcvores@outlook.es", LocalDate.of(2021,03,20));
		User user7 = new User("feresa","flobs@outlook.es", LocalDate.of(2021,03,20));
		User user8 = new User("bricny","flor@outlook.es", LocalDate.of(2021,03,20));
		User user9 = new User("bricny","flofnres@outlook.es", LocalDate.of(2021,03,20));
		User user10 = new User("shull","florwqes@outlook.es", LocalDate.of(2021,03,20));

		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);

		list.stream().forEach(userRepository::save);



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
