package ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")//Ĭ��Ϊsingleton
public class DemoPrototypeService {

}
