package br.com.flaviotvrs.tutorial.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.usecase.entity.Book;
import br.com.flaviotvrs.tutorial.usecase.gateway.BookFindByAuthorGateway;

@Component
public class BookFindByAuthorUseCase {

	private BookFindByAuthorGateway gateway;

	@Autowired
	public BookFindByAuthorUseCase(BookFindByAuthorGateway gateway) {
		this.gateway = gateway;
	}

	public List<Book> findByAuthor(Integer authorId) {
		return gateway.findByAuthor(authorId);
	}

}
