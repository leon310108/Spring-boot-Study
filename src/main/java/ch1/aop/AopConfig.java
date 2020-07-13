package ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("leon.aop")
@EnableAspectJAutoProxy//����spring ��AspectJ֧��
public class AopConfig {

}
