package com.duccao.kafka.consumers;

import com.duccao.kafka.configurations.KafkaConfigProperties;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class KafkaConsumerFactory<R> {

  public ConcurrentKafkaListenerContainerFactory<String, R> createListenerContainer(
      Class<R> requestClass,
      KafkaConfigProperties properties,
      Map<String, Object> configurations
  ) {
    ConcurrentKafkaListenerContainerFactory<String, R> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(createConsumerFactory(requestClass, properties, configurations));
    return factory;
  }

  private ConsumerFactory<String, R> createConsumerFactory(
      Class<R> requestClass,
      KafkaConfigProperties properties,
      Map<String, Object> configurations
  ) {
    Map<String, Object> defaultConfigurations = createDefaultConfigurations(properties);
    if (!configurations.isEmpty()) {
      defaultConfigurations.putAll(configurations);
    }

    JsonDeserializer<R> valueDeserializer = new JsonDeserializer<>(requestClass, false);
    valueDeserializer.addTrustedPackages("*");

    return new DefaultKafkaConsumerFactory<>(defaultConfigurations, new StringDeserializer(), valueDeserializer);
  }

  private Map<String, Object> createDefaultConfigurations(KafkaConfigProperties properties) {
    Map<String, Object> configurations = new HashMap<>();
    configurations.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
    configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServer());
    configurations.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, properties.getMaxPartitionFetchBytes());
    configurations.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, properties.getRequestTimeoutMs());
    configurations.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getGroupId());
    configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    return configurations;
  }
}
