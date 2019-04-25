package br.com.flaviotvrs.tutorial.usecase.gateway;

import java.util.List;

import br.com.flaviotvrs.tutorial.usecase.entity.Book;

public interface BookFindByAuthorGateway {

	List<Book> findByAuthor(Integer authorId);

}
