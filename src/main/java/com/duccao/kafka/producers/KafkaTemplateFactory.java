package com.duccao.kafka.producers;

import com.duccao.kafka.configurations.KafkaConfigProperties;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class KafkaTemplateFactory<T> {

  public KafkaTemplate<String, T> create(KafkaConfigProperties properties, String topic) {
    KafkaTemplate<String, T> kafkaTemplate = new KafkaTemplate<>(createProducerFactory(properties));
    kafkaTemplate.setDefaultTopic(topic);
    return kafkaTemplate;
  }

  private ProducerFactory<String, T> createProducerFactory(KafkaConfigProperties properties) {
    return new DefaultKafkaProducerFactory<>(createConfigurations(properties));
  }

  private Map<String, Object> createConfigurations(KafkaConfigProperties properties) {
    return Map.of(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServer(),
        ProducerConfig.MAX_REQUEST_SIZE_CONFIG, properties.getMaxRequestSize(),
        ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, properties.getRequestTimeoutMs(),
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
    );
  }
}
