package annotation3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import annotation3.service.FileService;

@Service("fileService")
//@PropertySource(value = {"jdbc.properties","classpath:common.properties", "classpath:abc.properties"})
public class FileServiceImpl implements FileService {

//    @Value("${sourceLocation:c:/temp/input}")
	@Value("${sourceLocation}")
	private String source;

//    @Value("${destinationLocation:c:/temp/output}")
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