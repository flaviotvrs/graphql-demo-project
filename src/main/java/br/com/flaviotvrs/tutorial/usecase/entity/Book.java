package br.com.flaviotvrs.tutorial.usecase.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

	private String id;
	private String name;
	private Integer pageCount;
	private Integer authorId;

}
