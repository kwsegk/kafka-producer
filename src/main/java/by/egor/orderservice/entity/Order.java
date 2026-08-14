package by.egor.orderservice.entity;

public record Order(
        String orderId,
        String product,
        Integer quantity
) {
}
