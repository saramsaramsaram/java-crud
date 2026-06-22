package com.dgsw.javacrud.items.controller;


import com.dgsw.javacrud.items.dto.ItemRequestDto;
import com.dgsw.javacrud.items.dto.ItemResponseDto;
import com.dgsw.javacrud.items.service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor

public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @GetMapping()
    public ResponseEntity<List<ItemResponseDto>> getAllItems() {
        return itemsService.getAllItems();
    }

    @PostMapping()
    public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemRequestDto requestItem) {
        return itemsService.createItem(requestItem);
    }
}
