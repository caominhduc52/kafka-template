package com.duccao.kafka.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@Getter
@Setter
public class KafkaConfigProperties {
  private String bootstrapServer;
  private String groupId;
  private String replyMessageMaximumSize;
  private String autoOffsetResetConfig;
  private String maxRequestSize;
  private String maxPartitionFetchBytes;
  private String requestTimeoutMs;
}
