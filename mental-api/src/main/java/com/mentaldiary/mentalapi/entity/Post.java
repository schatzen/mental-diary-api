package com.mentaldiary.mentalapi.entity;

import com.mentaldiary.mentalapi.entity.common.CommonDateEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends CommonDateEntity {

    @Id
    @SequenceGenerator(name = "POST_IDX_GEN", sequenceName = "POST_IDX_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_IDX_GEN")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;  // 게시글 - 회원의 관계 - N:1

    private String content;

    private Integer priority;

    private String status;

    // Join 테이블이 Json결과에 표시되지 않도록 처리.
    protected Category getBoard() {
        return category;
    }

    // 생성자
    public Post(User user, Category category, String content) {
        this.user = user;
        this.category = category;
        this.content = content;
    }



    // 수정시 데이터 처리
    public Post setUpdate(String content) {
        this.content = content;
        return this;
    }


}
