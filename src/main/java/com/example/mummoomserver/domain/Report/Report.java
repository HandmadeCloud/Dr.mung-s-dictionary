package com.example.mummoomserver.domain.Report;
import com.example.mummoomserver.config.BaseTimeEntity;
import com.example.mummoomserver.domain.Comment.Comment;
import com.example.mummoomserver.domain.Post.Post;

import com.example.mummoomserver.login.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@Table(name="Report")
@Entity
public class Report extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long reportIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="postIdx")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="commentIdx")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userIdx")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String reason;

    @Column
    @ColumnDefault("'active'")
    private String status;

    @Builder
    public Report(Post post, Comment comment, User user, String reason, String status){
        this.post = post;
        this.comment = comment;
        this.user = user;
        this.reason = reason;
        this.status = status;
    }
}
