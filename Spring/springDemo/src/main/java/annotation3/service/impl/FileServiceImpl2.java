package annotation3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import annotation3.service.FileService;

@Service("fileService2")
public class FileServiceImpl2 implements FileService {

	@Value("${sourceLocation}")
	private String source;

	@Value("${destinationLocation}")
	private String destination;

	@Autowired
	private Environment environment;

	public void readValues() {
		System.out
				.println("Getting property via Spring Environment :" + environment.getProperty("jdbc.driverClassName"));

		System.out.println("Source Location : " + source);
		System.out.println("Destination Location : " + destination);

	}

}