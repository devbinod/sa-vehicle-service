package edu.miu590.vehicle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Vehicle {

    @Id
    private String id;
    private Integer vin;
    private String description;
    private String model;
    private String brand;
    private String color;
    private LocalDate purchaseDate;
    private String userId;
    private BigDecimal pricePerDay;
}
