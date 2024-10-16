package com.duccao.kafka.configurations;

import com.duccao.kafka.consumers.KafkaConsumerFactory;
import java.util.Map;
import com.duccao.kafka.messages.ExampleMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

@Configuration
public class ConsumerConfiguration {

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, ExampleMessage> exampleMessageConsumer(
      KafkaConfigProperties properties
  ) {
    KafkaConsumerFactory<ExampleMessage> factory = new KafkaConsumerFactory<>();

    Map<String, Object> configurations = Map.of(
        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, properties.getAutoOffsetResetConfig(),
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ExampleMessage.class,
        ConsumerConfig.GROUP_ID_CONFIG, "1"
    );
    return factory.createListenerContainer(ExampleMessage.class, properties, configurations);
  }
}
