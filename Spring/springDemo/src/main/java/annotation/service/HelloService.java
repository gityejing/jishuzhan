package annotation.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String say() {
		return "hello world";
	}
}
