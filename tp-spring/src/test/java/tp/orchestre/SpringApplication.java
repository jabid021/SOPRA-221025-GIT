package tp.orchestre;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tp.orchestre.config.ApplicationConfig;

public class SpringApplication {

	public static void main(String[] args) throws Exception {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Principal principal = context.getBeanFactory().createBean(Principal.class);
		
		principal.run(args);
		
		
		context.close();
	}

}
