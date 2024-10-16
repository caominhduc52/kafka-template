# Kafka Spring Boot Template Project

![Kafka](https://img.shields.io/badge/Kafka-2.7.0-brightgreen.svg?logo=apache-kafka)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.4-brightgreen.svg?logo=spring-boot)
![Java](https://img.shields.io/badge/Java-21-blue.svg?logo=java)
![Maven](https://img.shields.io/badge/Maven-3.6.3-orange.svg?logo=apache-maven)

This repository provides a template project for setting up and using Kafka with Spring Boot. The project demonstrates the basic configuration required to produce and consume messages using Apache Kafka in a Spring Boot application.

Additionally, the project uses **generic techniques in Java** to create flexible, type-safe components for Kafka message consumption and production. This allows the Kafka consumers and producers to handle multiple DTO types seamlessly.

## Features

- ⚡ **Kafka Producer**: Demonstrates how to configure and send messages to a Kafka topic.
- 🎧 **Kafka Consumer**: Shows how to set up consumers to listen to specific Kafka topics.
- 🏗️ **Spring Boot Integration**: Leverages Spring Boot's auto-configuration for Kafka to simplify setup.
- ⚙️ **Customizable Configuration**: Easily configure Kafka properties like brokers, topic names, and more.

## Prerequisites

Before running the project, ensure you have the following installed:

- ☕ **Java 21** or later
- 🐘 **Apache Kafka** (A Kafka broker running locally or remotely)
- 📦 **Maven** (for building the project)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/kafka-spring-boot-template.git
cd kafka-spring-boot-template
