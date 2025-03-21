# Kafka Payment Service Example
A simple Spring Boot microservices-based application that showcases the use of Apache Kafka for event-driven architecture.

This project includes two microservices — payment-service and notification-service — that interact through Kafka to simulate payment processing and notification sending.

## Prerequisites
- Java 17
- Docker
- Spring Boot
- Apache Kafka

## Kafka Flow

1. **Payment Service** creates a payment and sends an event to Kafka.
2. **Notification Service** listens to the Kafka topic and processes the event when it arrives.

## Test the Application

Send a POST request to create a payment in the Payment Service at the following endpoint:

```
http://localhost:8080/payment
```
With the following request body (you can replace the values as needed):
```
{
  "sum": 150.50,
  "createdAt": "2025-03-19T10:30:00",
  "orderId": "order12345",
  "userId": "user98765"
}
```
Check the logs of both the Payment Service and Notification Service to see the Kafka event being sent and received. The Payment Service should send an event, and the Notification Service should receive it and process it accordingly.

