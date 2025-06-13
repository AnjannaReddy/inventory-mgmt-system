package com.phegondev.InventoryMgtSystem.services;

import com.phegondev.InventoryMgtSystem.dtos.PurchaseRequest;
import com.phegondev.InventoryMgtSystem.dtos.Response;
import com.phegondev.InventoryMgtSystem.models.Product;
import com.phegondev.InventoryMgtSystem.models.Purchase;
import com.phegondev.InventoryMgtSystem.models.Supplier;
import com.phegondev.InventoryMgtSystem.repositories.ProductRepository;
import com.phegondev.InventoryMgtSystem.repositories.PurchaseRepository;
import com.phegondev.InventoryMgtSystem.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public Response addPurchase(PurchaseRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        Purchase purchase = Purchase.builder()
                .product(product)
                .supplier(supplier)
                .description(request.getDescription())
                .note(request.getNote())
                .quantity(request.getQuantity())
                .purchaseDate(LocalDateTime.now())
                .build();

        purchaseRepository.save(purchase);

        return Response.builder()
                .status(HttpStatus.CREATED.value())
                .message("Purchase added successfully")
                .data(purchase)
                .build();
    }
}
