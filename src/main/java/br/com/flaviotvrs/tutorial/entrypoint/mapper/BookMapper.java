package br.com.flaviotvrs.tutorial.entrypoint.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.flaviotvrs.tutorial.entrypoint.model.BookResponseModel;
import br.com.flaviotvrs.tutorial.usecase.entity.Book;

public class BookMapper {

	public static BookResponseModel toResponseModel(Book entity) {
		BookResponseModel model = null;
		if (entity != null) {
			model = new BookResponseModel(entity.getId(), entity.getName(), entity.getPageCount(), entity.getAuthorId(),
					entity.getPublished().toString(), entity.getIsbn10(), entity.getIsbn13());
		}
		return model;
	}

	public static List<BookResponseModel> toResponseModel(List<Book> list) {
		return list.stream().map(entity -> toResponseModel(entity)).collect(Collectors.toList());
	}

}
