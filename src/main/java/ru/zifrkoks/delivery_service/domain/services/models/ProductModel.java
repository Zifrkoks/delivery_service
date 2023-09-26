package ru.zifrkoks.delivery_service.domain.services.models;

import lombok.Data;

@Data
public class ProductModel {
    private String name;
    private String description;
    private int cost;
}
