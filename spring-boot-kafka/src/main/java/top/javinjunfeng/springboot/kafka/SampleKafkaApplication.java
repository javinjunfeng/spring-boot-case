package top.javinjunfeng.springboot.kafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleKafkaApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(Producer producer) {
		return (args) -> producer.send(new SampleMessage(1, "A simple test message"));
	}

}
