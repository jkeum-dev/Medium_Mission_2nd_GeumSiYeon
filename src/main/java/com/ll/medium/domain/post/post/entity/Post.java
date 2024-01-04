package com.ll.medium.domain.post.post.entity;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.post.postLike.entity.PostLike;
import com.ll.medium.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
public class Post extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Member author;
	private String title;
	private String body;
	private boolean isPublished;
	@Setter(PROTECTED)
	private long hit;
	@OneToMany(mappedBy = "post", cascade = ALL, orphanRemoval = true)
	@Builder.Default
	private List<PostLike> likes = new ArrayList<>();

	public void increaseHit() {
		hit++;
	}

	public void addLike(Member member) {
		if (hasLike(member)) {
			return;
		}

		likes.add(PostLike.builder()
				.post(this)
				.member(member)
				.build()
		);
	}

	public boolean hasLike(Member member) {
		return likes.stream()
				.anyMatch(postLike -> postLike.getMember().equals(member));
	}

	public void deleteLike(Member member) {
		likes.removeIf(postLike -> postLike.getMember().equals(member));
	}
}
