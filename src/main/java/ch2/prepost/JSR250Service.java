package ch2.prepost;

import javax.annotation.PostConstruct;

public class JSR250Service {
	
	@PostConstruct
	public void init() {
		System.out.println("init.....");
	}
	
	public JSR250Service() {
		// TODO Auto-generated constructor stub
		System.out.println("JSR250Serviceππ‘Ï∑®");
	}
	
}
