package httpserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("httpserver")
public class ConfigTest {
	
	@Bean(initMethod="init" ,destroyMethod="destroy")
	Test1 test1() {
		return new Test1();
	}

}
