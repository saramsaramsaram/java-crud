package com.dgsw.javacrud.items.service;

import com.dgsw.javacrud.items.dto.ItemRequestDto;
import com.dgsw.javacrud.items.dto.ItemResponseDto;
import com.dgsw.javacrud.items.entity.Item;
import com.dgsw.javacrud.items.entity.ItemStatus;
import com.dgsw.javacrud.items.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public String addItem(@RequestBody Item item) {
        itemsRepository.save(item);
        return "아이템이 성공적으로 추가되었습니다.";
    }

    public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setName(itemRequestDto.getName());
        item.setCategory(itemRequestDto.getCategory());
        item.setStatus(ItemStatus.AVAILABLE);
        item.setBorrower(itemRequestDto.getBorrower());
        item.setReturnDate(itemRequestDto.getReturnDate());

        Item savedItem = itemsRepository.save(item);

        return ResponseEntity.ok(new ItemResponseDto(savedItem.getId(), savedItem.getName(), savedItem.getCategory(), savedItem.getStatus(), savedItem.getBorrower(), savedItem.getReturnDate()));
    }
}
