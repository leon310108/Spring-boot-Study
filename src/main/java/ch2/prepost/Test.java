package ch2.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext  context=new AnnotationConfigApplicationContext(PrePostConfig.class);
//		BeanWayService beanWayService=context.getBean(BeanWayService.class);
//		JSR250WayService jsr250WayService=context.getBean(JSR250WayService.class);
//		BeanService beanService=context.getBean(BeanService.class);
		
		context.close();

	}

}
