package com.duccao.kafka.producers;

import com.duccao.kafka.messages.ExampleMessage;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
  private final KafkaTemplate<String, ExampleMessage> exampleMessageKafkaTemplate;

  public Producer(KafkaTemplate<String, ExampleMessage> exampleMessageKafkaTemplate) {
    this.exampleMessageKafkaTemplate = exampleMessageKafkaTemplate;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void sendExampleMessage() {
    ExampleMessage message = ExampleMessage.builder().id("1").name("Duc Cao").build();
    exampleMessageKafkaTemplate.sendDefault("1", message);
  }
}
