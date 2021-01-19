package com.mentaldiary.mentalapi.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PostComment {

    @Id
    @SequenceGenerator(name = "POST_COMMENT_IDX_GEN", sequenceName = "POST_COMMENT_IDX_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_COMMENT_IDX_GEN")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private String comment;

    @Column
    private String status;
}
