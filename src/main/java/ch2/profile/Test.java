package ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		context.register(ProfileConfig.class);
		context.refresh();
		
		DemoBean demoBean=context.getBean(DemoBean.class);
		System.out.println(demoBean.getContent());
		
		context.close();

	}

}
