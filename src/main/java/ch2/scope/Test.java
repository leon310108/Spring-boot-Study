package ch2.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ScopeConfig.class);
		DemoSingletonService s1=context.getBean(DemoSingletonService.class);
		DemoSingletonService s2=context.getBean(DemoSingletonService.class);
		
		DemoPrototypeService p1=context.getBean(DemoPrototypeService.class);
		DemoPrototypeService p2=context.getBean(DemoPrototypeService.class);
		
		System.out.println(s1.equals(s2));
		System.out.println(p1.equals(p2));

	}

}
