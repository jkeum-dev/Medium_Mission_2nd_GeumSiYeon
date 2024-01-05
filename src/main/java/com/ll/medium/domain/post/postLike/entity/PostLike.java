package com.ll.medium.domain.post.postLike.entity;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.post.post.entity.Post;
import com.ll.medium.global.jpa.IdEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLike extends IdEntity {
	@ManyToOne
	private Post post;
	@ManyToOne
	private Member member;
}
