package br.com.flaviotvrs.tutorial.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.usecase.entity.Book;
import br.com.flaviotvrs.tutorial.usecase.gateway.BookFindByNameGateway;

@Component
public class BookFindByNameUseCase {

	private BookFindByNameGateway gateway;

	@Autowired
	public BookFindByNameUseCase(BookFindByNameGateway gateway) {
		this.gateway = gateway;
	}

	public List<Book> findByName(String bookName) {
		return gateway.findByName(bookName);
	}

}
