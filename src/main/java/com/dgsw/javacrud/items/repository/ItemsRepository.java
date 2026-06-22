package com.dgsw.javacrud.items.repository;


import com.dgsw.javacrud.items.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Item, Long> {
}
