package com.dgsw.javacrud.items.service;

import com.dgsw.javacrud.items.dto.ItemRequestDto;
import com.dgsw.javacrud.items.dto.ItemResponseDto;
import com.dgsw.javacrud.items.dto.ItemStatusDto;
import com.dgsw.javacrud.items.entity.Item;
import com.dgsw.javacrud.items.entity.ItemStatus;
import com.dgsw.javacrud.items.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public ResponseEntity<ItemResponseDto> createItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setName(itemRequestDto.getName());
        item.setCategory(itemRequestDto.getCategory());
        item.setStatus(ItemStatus.AVAILABLE);
        item.setBorrower(itemRequestDto.getBorrower());
        item.setReturnDate(itemRequestDto.getReturnDate());

        Item savedItem = itemsRepository.save(item);

        return ResponseEntity.ok(new ItemResponseDto(savedItem.getId(), savedItem.getName(), savedItem.getCategory(), savedItem.getStatus(), savedItem.getBorrower(), savedItem.getReturnDate()));
    }

    public ResponseEntity<ItemResponseDto> getItemById(Long id) {
        Item item =  itemsRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        return ResponseEntity.ok(new ItemResponseDto(item.getId(), item.getName(), item.getCategory(), item.getStatus(), item.getBorrower(), item.getReturnDate()));
    }

    public ResponseEntity<ItemResponseDto> updateStatus(Long id, ItemStatusDto itemStatusDto) {
        Item item = itemsRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setStatus(itemStatusDto.getStatus());

        Item savedItem = itemsRepository.save(item);
        return ResponseEntity.ok(new ItemResponseDto(savedItem.getId(), savedItem.getName(), savedItem.getCategory(), savedItem.getStatus(), savedItem.getBorrower(), savedItem.getReturnDate()));
    }
    public ResponseEntity<List<ItemResponseDto>> getAllItems() {
        List<ItemResponseDto> items = itemsRepository.findAll().stream()
                .map(item -> new ItemResponseDto(item.getId(), item.getName(), item.getCategory(), item.getStatus(), item.getBorrower(), item.getReturnDate()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(items);
    }

    public ResponseEntity<ItemResponseDto> updateItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = itemsRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(itemRequestDto.getName());
        item.setCategory(itemRequestDto.getCategory());
        item.setBorrower(itemRequestDto.getBorrower());
        item.setReturnDate(itemRequestDto.getReturnDate());

        Item savedItem = itemsRepository.save(item);
        return ResponseEntity.ok(new ItemResponseDto(savedItem.getId(), savedItem.getName(), savedItem.getCategory(), savedItem.getStatus(), savedItem.getBorrower(), savedItem.getReturnDate()));
    }

    public ResponseEntity<Void> deleteItem(Long id) {
        itemsRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        itemsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
