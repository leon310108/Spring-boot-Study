package ch2.e1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(E1config.class);
		E1config e1=context.getBean(E1config.class);
		e1.outputResource();
		context.close();

	}

}
