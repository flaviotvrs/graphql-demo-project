package br.com.flaviotvrs.tutorial.dataprovider.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.flaviotvrs.tutorial.dataprovider.repository.entity.BookEntity;
import br.com.flaviotvrs.tutorial.usecase.entity.Book;

public class BookMapper {

	public static Book toBusinessEntity(Optional<BookEntity> entity) {
		Book businessEntity = null;
		if (entity.isPresent()) {
			BookEntity bookEntity = entity.get();
			businessEntity = Book.builder().id(bookEntity.getId()).name(bookEntity.getName())
					.pageCount(bookEntity.getPageCount()).authorId(bookEntity.getAuthorId())
					.published(bookEntity.getPublished()).isbn10(bookEntity.getIsbn10()).isbn13(bookEntity.getIsbn13())
					.build();
		}
		return businessEntity;
	}

	public static List<Book> toBusinessEntity(List<BookEntity> list) {
		return list.stream().map(entity -> toBusinessEntity(Optional.ofNullable(entity))).collect(Collectors.toList());
	}

}
