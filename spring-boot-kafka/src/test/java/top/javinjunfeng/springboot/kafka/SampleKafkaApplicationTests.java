package top.javinjunfeng.springboot.kafka;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}")
@EmbeddedKafka
public class SampleKafkaApplicationTests {

	@Autowired
	private Consumer consumer;

	@Test
	public void testVanillaExchange() throws Exception {
		long end = System.currentTimeMillis() + 10000;
		List<SampleMessage> messages = this.consumer.getMessages();
		while (messages.size() != 1 && System.currentTimeMillis() < end) {
			Thread.sleep(250);
		}
		assertThat(messages).hasSize(1);
		assertThat(messages.get(0).getMessage()).isEqualTo("A simple test message");
	}

}
