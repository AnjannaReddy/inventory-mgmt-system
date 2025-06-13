package com.phegondev.InventoryMgtSystem.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phegondev.InventoryMgtSystem.enums.UserRole;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    // Generic status and message
    private int status;
    private String message;

    // Token-based authentication details
    private String token;
    private UserRole role;
    private String expirationTime;

    // Pagination support
    private Integer totalPages;
    private Long totalElements;

    // Optional single or list of DTOs
    private UserDTO user;
    private List<UserDTO> users;

    private SupplierDTO supplier;
    private List<SupplierDTO> suppliers;

    private CategoryDTO category;
    private List<CategoryDTO> categories;

    private ProductDTO product;
    private List<ProductDTO> products;

    private TransactionDTO transaction;
    private List<TransactionDTO> transactions;

    // Generic fallback for any other type of data (like Purchase)
    private Object data;

    // Timestamp of response creation
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
