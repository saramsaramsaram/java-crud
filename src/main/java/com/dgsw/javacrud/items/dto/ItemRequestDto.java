package com.dgsw.javacrud.items.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemRequestDto {
    private String name;
    private String category;
    private String borrower;
    private String returnDate;
}
