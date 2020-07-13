package ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DiConfig.class);
		UseFunctionService useFunctionService=context.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.SayHello("di"));
		context.close();

	}

}
