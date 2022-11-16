package com.study.springstudy.entity.board;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "post", nullable = false)
    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Post post;

    @Column(name = "", nullable = false)
    private Long writerId;

    @Column(name = "", nullable = false)
    private String contents;

    @Column(name = "", nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "", nullable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;


    @Column(name = "", nullable = false)
    private Boolean isDeleted = false;

    @Builder
    public Comment(String contents, Boolean isDeleted) {
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
