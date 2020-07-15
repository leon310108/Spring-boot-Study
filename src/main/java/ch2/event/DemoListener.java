package ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	@Override
	public void onApplicationEvent(DemoEvent event) {
		// TODO Auto-generated method stub
		String msg=event.getMsg();
		System.out.println("��(bean-demoListener)���յ���bean-demoPublisher��������Ϣ��"+msg);
		
	}

}
