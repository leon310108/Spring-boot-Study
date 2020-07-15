package ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EventConfig.class);
		DemoPublisher demoPublisher=context.getBean(DemoPublisher.class);
		demoPublisher.publish("Hello application event");
		context.close();
	}
}
