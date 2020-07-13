package ch1.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public FunctionService functionService() {
		return new FunctionService();
	}
	
	@Bean
	public UseFunctionService useFunctionService() {
		UseFunctionService useFunctionService=new UseFunctionService();
		useFunctionService.setFunctionService(functionService());
		return useFunctionService;
	}

//	@Bean
//	public UseFunctionService useFunctionService(FunctionService functionService) {
//		UseFunctionService useFuncitonService=new UseFunctionService();
//		useFuncitonService.setFunctionService(functionService);
//		return useFuncitonService;
//	}
}
