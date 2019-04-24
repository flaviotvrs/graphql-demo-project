package br.com.flaviotvrs.tutorial.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.usecase.entity.Book;
import br.com.flaviotvrs.tutorial.usecase.gateway.BookFindByIdGateway;

@Component
public class BookFindByIdUseCase {

	private BookFindByIdGateway gateway;

	@Autowired
	public BookFindByIdUseCase(BookFindByIdGateway gateway) {
		this.gateway = gateway;
	}

	public Book findById(String bookId) {
		return gateway.findById(bookId);
	}

}
