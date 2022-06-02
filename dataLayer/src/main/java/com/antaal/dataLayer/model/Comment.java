package com.antaal.dataLayer.model;

import javax.persistence.*;

@Entity
@Table(name = "commentaire")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentaire_id")
    private int commentId;
    @Column(name = "contenu")
    private String Content;
    @ManyToOne(
            cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE

            }
    )
    @JoinColumn(name = "produit_id")
    private Product product;
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setProduct(Product product) {
    }
}
