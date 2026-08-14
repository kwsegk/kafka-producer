package by.egor.orderservice.service;

import by.egor.orderservice.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderKafkaProducer orderKafkaProducer;

    public OrderService(OrderKafkaProducer orderKafkaProducer) {
        this.orderKafkaProducer = orderKafkaProducer;
    }

    public void saveOrder(Order order) {
        // saving to Database
        orderKafkaProducer.semdOrderToKafka(order);
        log.info("Order successfully saved: id={}", order.orderId());
    }
}
