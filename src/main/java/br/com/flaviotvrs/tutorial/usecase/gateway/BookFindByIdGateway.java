package br.com.flaviotvrs.tutorial.usecase.gateway;

import br.com.flaviotvrs.tutorial.usecase.entity.Book;

public interface BookFindByIdGateway {

	Book findById(String bookId);

}
