# Spring Kafka Email Service

A Spring Boot microservice that consumes `UserCreated` events from Apache Kafka.

This service demonstrates how downstream services can asynchronously process business events without being tightly coupled to the event producer.

---

## Features

- Consume `UserCreated` events from Kafka
- Process user registration events
- Simulate welcome email delivery
- Asynchronous event processing

---

## Tech Stack

- Java 21
- Spring Boot
- Apache Kafka
- Gradle

---

## Architecture

```text
Kafka Topic (user-created)
            │
            ▼
     Email Service
            │
Consume UserCreated Event
            │
            ▼
 Simulate Welcome Email (Log)
```

---

## Event Flow

1. The Email Service subscribes to the `user-created` topic.
2. Kafka delivers the `UserCreated` event.
3. The Email Service consumes the event.
4. A welcome email is simulated through logging.

---

## Purpose

The Email Service is responsible for processing user registration events published by the User Service.

By consuming events from Kafka instead of receiving direct REST API calls, it can operate independently of the producer. This enables loose coupling, fault isolation, and allows additional consumer services to subscribe to the same event without modifying the User Service.

---

## Related Project

- [spring-kafka-practice](https://github.com/zzzyoonnn/spring-kafka-practice)
- [spring-kafka-user-service](https://github.com/zzzyoonnn/spring-kafka-user-service)