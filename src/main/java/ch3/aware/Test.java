package ch3.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService awareService=context.getBean(AwareService.class);
		awareService.outputResult();
		context.close();

	}

}
