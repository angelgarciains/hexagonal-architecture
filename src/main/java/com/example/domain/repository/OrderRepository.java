package com.example.domain.repository;

import com.example.domain.model.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public class OrderRepository implements PanacheRepository<Order> {


}
