package ch2.e1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ch2.e1")
@PropertySource("classpath:ch2/e1/test.properties")
public class E1config {

	@Value("I Love You£¡")
	private String normal;
	
	@Value("#{systemProperties['os.name']}")
	private String osName;
}
