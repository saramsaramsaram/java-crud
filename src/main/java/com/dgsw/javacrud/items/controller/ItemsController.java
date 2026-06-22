package com.dgsw.javacrud.items.controller;


import com.dgsw.javacrud.items.dto.ItemRequestDto;
import com.dgsw.javacrud.items.dto.ItemResponseDto;
import com.dgsw.javacrud.items.entity.Item;
import com.dgsw.javacrud.items.entity.ItemStatus;
import com.dgsw.javacrud.items.service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor

public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @PostMapping()
    public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemRequestDto requestItem) {
        return itemsService.createItem(requestItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponseDto> getItemById(@PathVariable Long id) {
        return  itemsService.getItemById(id);
    }
}
