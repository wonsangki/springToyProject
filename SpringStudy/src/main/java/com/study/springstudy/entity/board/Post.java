package com.study.springstudy.entity.board;

import com.study.springstudy.entity.auth.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Long userId;

    private String contents;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @OneToMany(mappedBy = "post")
    private List<Comment> commentList = new ArrayList<Comment>();

    private Boolean isDeleted;

    @Builder
    public Post(String title, String contents, Boolean isDeleted){
        this.title = title;
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
