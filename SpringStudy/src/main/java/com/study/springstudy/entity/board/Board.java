package com.study.springstudy.entity.board;

import com.study.springstudy.enums.UserGrade;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "board")
    List<Post> postList = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    private UserGrade accessibleGrade = UserGrade.NORMAL;
    private Boolean isActivated = true;
    private Boolean isDeleted = false;

    @Builder
    public Board(UserGrade grade, Boolean isActivated, Boolean isDeleted){
        this.accessibleGrade = grade;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
    }
}
