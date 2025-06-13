package com.phegondev.InventoryMgtSystem.dtos;

import lombok.Data;

@Data
public class PurchaseRequest {
    private Long productId;
    private Long supplierId;
    private String description;
    private String note;
    private int quantity;
}
