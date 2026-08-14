package by.egor.orderservice.service;

import by.egor.orderservice.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;
    private static final Logger log = LoggerFactory.getLogger(OrderKafkaProducer.class);

    public OrderKafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void semdOrderToKafka(Order order) {
        kafkaTemplate.send("orders", order);
        log.info("Order sent to kafka: id={}", order.orderId());
    }
}
