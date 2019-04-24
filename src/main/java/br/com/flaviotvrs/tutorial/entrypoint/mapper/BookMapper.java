package br.com.flaviotvrs.tutorial.entrypoint.mapper;

import br.com.flaviotvrs.tutorial.entrypoint.model.BookResponseModel;
import br.com.flaviotvrs.tutorial.usecase.entity.Book;

public class BookMapper {

	public static BookResponseModel toResponseModel(Book entity) {
		BookResponseModel model = null;
		if (entity != null) {
			model = new BookResponseModel(entity.getId(), entity.getName(), entity.getPageCount(),
					entity.getAuthorId());
		}
		return model;
	}

}
