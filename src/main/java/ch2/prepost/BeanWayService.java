package ch2.prepost;

public class BeanWayService {
	
	public void init() {
		System.out.println("@Bean-init-method");
	}
	BeanWayService(){
		System.out.println("��ʼ�����캯��-BeanWayService");
	}
	
	public void destroy() {
		System.out.println("@Bean-destroy-method");
	}
	
}
