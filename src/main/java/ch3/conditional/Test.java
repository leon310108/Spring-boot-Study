package ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConditonConfig.class);
		ListService listService=context.getBean(ListService.class);
		System.out.println(context.getEnvironment().getProperty("os.name")+"ϵͳ�µ��б�����Ϊ��"+listService.showListCmd());

	}

}
