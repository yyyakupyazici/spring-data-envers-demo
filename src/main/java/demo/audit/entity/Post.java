package demo.audit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.springframework.data.history.RevisionMetadata;

import lombok.Data;

@Entity
@Audited
@Data
public class Post {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "post_Title")
	private String postTitle;

	@Column(name = "post_Content")
	private String postContent;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@Transient
	private RevisionMetadata<Integer> editVersion;

}
