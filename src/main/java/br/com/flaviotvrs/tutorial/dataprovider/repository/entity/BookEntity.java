package br.com.flaviotvrs.tutorial.dataprovider.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {

	@Id
	@Column(name = "ID", nullable = false, length = 50)
	private String id;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "PAGE_COUNT", nullable = false, precision = 9, scale = 0)
	private Integer pageCount;

	@Column(name = "AUTHOR_ID", nullable = false, length = 50)
	private String authorId;

}
