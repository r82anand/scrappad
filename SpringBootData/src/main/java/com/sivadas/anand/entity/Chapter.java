package com.sivadas.anand.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sivadas.anand.entity.audit.Auditable;

@Entity(name = "Chapter")
@Table(name = "CHAPTER")
@NamedQuery(name = "Chapter.findAllChapters", query = "SELECT t FROM Chapter t")
public class Chapter extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 6438779629485768640L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "TITLE")
	private String title;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TOPIC_ID")
	@JsonIgnore
	private Topic topic;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "content_id")
	private Contents contents;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "section_id")
	private Chapter section;

	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
	private Set<Chapter> sections = new HashSet<Chapter>();

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(final Topic topic) {
		this.topic = topic;
	}

	public Contents getContents() {
		return contents;
	}

	public void setContents(final Contents contents) {
		this.contents = contents;
	}

	public Chapter getSection() {
		return section;
	}

	public void setSection(final Chapter section) {
		this.section = section;
	}

	public Set<Chapter> getSections() {
		return sections;
	}

	public void setSections(final Set<Chapter> sections) {
		this.sections = sections;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Chapter other = (Chapter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ "]";
	}

}
