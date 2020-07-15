package ch2.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {
	@PostConstruct
	public void init() {
		System.out.println("jsr250-init-method");
	}
	
	public JSR250WayService() {
		System.out.println("��ʼ�����캯��-JSR250WayService");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("jsr250-destory-method");
	}

}
