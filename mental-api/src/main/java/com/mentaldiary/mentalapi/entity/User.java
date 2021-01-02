package com.mentaldiary.mentalapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="USER_IDX_GEN", sequenceName = "USER_IDX_SEQ", initialValue = 1, allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_IDX_GEN")
    private Long userIdx;

    private String email;

    private String password;

    private String birthdate;

    private Integer gender;
}
