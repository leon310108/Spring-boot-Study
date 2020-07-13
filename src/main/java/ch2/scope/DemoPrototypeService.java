package ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")//Ä¬ÈÏÎªsingleton
public class DemoPrototypeService {

}
