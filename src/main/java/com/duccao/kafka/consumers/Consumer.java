package com.duccao.kafka.consumers;

import com.duccao.kafka.constans.Topic;
import com.duccao.kafka.messages.ExampleMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

  @KafkaListener(topics = Topic.EXAMPLE_TOPIC, containerFactory = "exampleMessageListenerContainerFactory")
  public void process(ConsumerRecord<String, ExampleMessage> record) {
    System.out.println(record.key());
    System.out.println(record.value());
  }
}
