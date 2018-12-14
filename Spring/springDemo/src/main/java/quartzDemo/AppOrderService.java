package quartzDemo;

import org.springframework.stereotype.Service;

@Service
public class AppOrderService {
	
	public void sayHello(String name) {
		System.out.println("hello "+name);
	}

}
