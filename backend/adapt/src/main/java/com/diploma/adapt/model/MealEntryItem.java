package com.diploma.adapt.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "food")
public class MealEntryItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    private MealEntry meal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product productDetails;

    @Column(nullable = false)
    private Double amount;
}