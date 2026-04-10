package com.diploma.adapt.repository;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diploma.adapt.model.MealEntry;
import com.diploma.adapt.model.MealType;
import com.diploma.adapt.model.User;

public interface MealEntryRepository extends JpaRepository<MealEntry, UUID> {
    List<MealEntry> findByUserAndDate(User user, LocalDate date);

    Optional<MealEntry> findByUserAndDateAndType(User user, LocalDate date, MealType type);
}