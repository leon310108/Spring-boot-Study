package ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("leon.aop")
@EnableAspectJAutoProxy//开启spring 对AspectJ支持
public class AopConfig {

}
