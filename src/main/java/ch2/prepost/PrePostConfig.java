package ch2.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ch2.prepost")
public class PrePostConfig {
	
	@Bean(initMethod = "init" ,destroyMethod = "destroy")
	BeanWayService beanWayService() {
		return new BeanWayService();
	}
	
	@Bean
	JSR250WayService jsr250WayService() {
		return new JSR250WayService();
	}
	
	@Bean(initMethod = "init")
	BeanService beanService() {
		return new BeanService();
	}

}
