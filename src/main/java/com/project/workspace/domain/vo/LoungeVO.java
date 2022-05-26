package com.project.workspace.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "tbl_lounge")
@ToString(exclude = {"userVO", "replies", "likes"})
@Getter
@Setter
@AllArgsConstructor
@DynamicInsert
public class LoungeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lounge_num")
    private Long loungeNum;
    @Column(name = "lounge_content")
    private String loungeContent;
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lounge_date")
    private Date loungeDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @JsonIgnore
    @OneToMany(mappedBy = "loungeVO")
    private List<LoungeReplyVO> replies = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "loungeVO")
    private List<LoungeLikeVO> likes = new ArrayList<>();

    @Builder
        public LoungeVO(Long loungeNum, String loungeContent, String loungeDate, UserVO userVO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.loungeNum = loungeNum;
        this.loungeContent = loungeContent;
        try {
           if(loungeDate!=null){this.loungeDate = sdf.parse(loungeDate);}
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.userVO = userVO;
    }
    public LoungeVO(){;}
}
