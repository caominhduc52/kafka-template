package com.duccao.kafka.configurations;

import com.duccao.kafka.constans.Topic;
import com.duccao.kafka.messages.ExampleMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import com.duccao.kafka.producers.KafkaTemplateFactory;

@Configuration
public class ProducerConfiguration {

  @Bean
  public KafkaTemplate<String, ExampleMessage> exampleMessageKafkaTemplate(KafkaConfigProperties properties) {
    KafkaTemplateFactory<ExampleMessage> factory = new KafkaTemplateFactory<>();
    return factory.create(properties, Topic.EXAMPLE_TOPIC);
  }
}
