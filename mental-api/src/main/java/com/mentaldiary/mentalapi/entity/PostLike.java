package com.mentaldiary.mentalapi.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PostLike {

    @Id
    @SequenceGenerator(name = "POST_LIKE_IDX_GEN", sequenceName = "POST_LIKE_IDX_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_LIKE_IDX_GEN")
    private Long id;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;


}
