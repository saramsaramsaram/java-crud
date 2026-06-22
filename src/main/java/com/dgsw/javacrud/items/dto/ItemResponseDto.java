package com.dgsw.javacrud.items.dto;

import com.dgsw.javacrud.items.entity.ItemStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ItemResponseDto {
    private Long id;
    private String name;
    private String category;
    private ItemStatus status;
    private String borrower;
    private String returnDate;

    public ItemResponseDto(Long id, String name, String category, ItemStatus status, String borrower, String returnDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.borrower = borrower;
        this.returnDate = returnDate;
    }
}
