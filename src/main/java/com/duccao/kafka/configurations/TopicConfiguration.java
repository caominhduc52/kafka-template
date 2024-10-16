package com.duccao.kafka.configurations;

import com.duccao.kafka.constans.KafkaConstant;
import com.duccao.kafka.constans.Topic;
import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfiguration {

  @Bean
  public NewTopic createExampleTopic() {
    Map<String, String> configurations = Map.of(
        TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE
    );

    NewTopic topic = new NewTopic(
        Topic.EXAMPLE_TOPIC,
        KafkaConstant.NUMBER_OF_PARTITIONS,
        KafkaConstant.REPLICATION_FACTOR
    );
    topic.configs(configurations);
    return topic;
  }
}
