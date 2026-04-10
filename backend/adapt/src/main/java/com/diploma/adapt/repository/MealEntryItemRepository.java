package com.diploma.adapt.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diploma.adapt.model.MealEntry;
import com.diploma.adapt.model.MealEntryItem;

public interface MealEntryItemRepository extends JpaRepository<MealEntryItem, UUID> {
    List<MealEntryItem> findByMeal(MealEntry entry);
}