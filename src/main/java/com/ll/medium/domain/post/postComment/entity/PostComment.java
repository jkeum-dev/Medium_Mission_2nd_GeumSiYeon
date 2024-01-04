package com.ll.medium.domain.post.postComment.entity;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.post.post.entity.Post;
import com.ll.medium.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
public class PostComment extends BaseEntity {
	@ManyToOne
	private Member author;
	@ManyToOne
	private Post post;
	@Column(columnDefinition = "TEXT")
	private String body;
}
