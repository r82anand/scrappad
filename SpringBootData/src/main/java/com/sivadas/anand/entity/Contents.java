package com.sivadas.anand.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sivadas.anand.entity.audit.Auditable;

@Entity(name = "Contents")
@Table(name = "CONTENTS")
public class Contents extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = -4727218515136333307L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "TEXT")
	@Lob
	private String content;
	@OneToOne(mappedBy = "contents", fetch = FetchType.EAGER, optional = false)
	private Chapter chapter;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(final Chapter chapter) {
		if (chapter == null) {
			if (this.chapter != null) {
				this.chapter.setContents(null);
			}
		} else {
			chapter.setContents(this);
		}
		this.chapter = chapter;
	}

	@Override
	public String toString() {
		return "Contents [id=" + id + ", content=" + content + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + "]";
	}
}
