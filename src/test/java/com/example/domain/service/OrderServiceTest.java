package com.example.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.domain.model.Order;
import com.example.domain.model.OrderItem;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class OrderServiceTest {

  @Inject
  OrderService orderService;

  @Test
  public void testCreateOrder() {
    Order order = new Order(LocalDateTime.now(), "PENDING");
    orderService.createOrder(order);
    assertNotNull(order.getId());
  }

  @Test
  public void testAddItemToOrder() {
    Order order = new Order(LocalDateTime.now(), "PENDING");
    orderService.createOrder(order);
    OrderItem item = new OrderItem("product1", 2, new BigDecimal("10.0"));
    orderService.addItemToOrder(order.getId(), item);
    assertEquals(1, orderService.findOrderByid(order.getId()).getItems().size());
  }

  @Test
  public void testUpdateOrderStatus() {
    Order order = new Order(LocalDateTime.now(), "PENDING");
    orderService.createOrder(order);
    orderService.updateOrderStatus(order.getId(), "CONFIRMED");
    assertEquals("CONFIRMED", orderService.findOrderByid(order.getId()).getStatus());
  }


}
