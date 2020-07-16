package ch3.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("ÿ������ִ��һ��"+dateFormat.format(new Date()));
	}
	
	@Scheduled(cron = "0 52 15 ? * *")
	public void fixTimeExecution() {
		System.out.println("��ָ��ʱ��"+dateFormat.format(new Date())+"ִ��");
	}
}
