package com.mentaldiary.mentalapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Category {

    @Id
    @SequenceGenerator(name = "CATEGORY_IDX_GEN", sequenceName = "CATEGORY_IDX_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_IDX_GEN")
    private Long id;

    private String name;

}
