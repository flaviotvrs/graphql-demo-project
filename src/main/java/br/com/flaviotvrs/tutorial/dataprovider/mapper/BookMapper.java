package br.com.flaviotvrs.tutorial.dataprovider.mapper;

import java.util.Optional;

import br.com.flaviotvrs.tutorial.dataprovider.repository.entity.BookEntity;
import br.com.flaviotvrs.tutorial.usecase.entity.Book;

public class BookMapper {

	public static Book toBusinessEntity(Optional<BookEntity> entity) {
		Book businessEntity = null;
		if (entity.isPresent()) {
			BookEntity bookEntity = entity.get();
			businessEntity = Book.builder().id(bookEntity.getId()).name(bookEntity.getName())
					.pageCount(bookEntity.getPageCount()).authorId(bookEntity.getAuthorId()).build();
		}
		return businessEntity;
	}

}
