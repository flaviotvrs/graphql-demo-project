package br.com.flaviotvrs.tutorial.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.usecase.entity.Book;
import br.com.flaviotvrs.tutorial.usecase.gateway.BookFindAllGateway;

@Component
public class BookFindAllUseCase {

	private BookFindAllGateway gateway;

	@Autowired
	public BookFindAllUseCase(BookFindAllGateway gateway) {
		this.gateway = gateway;
	}

	public List<Book> findAll(int page, int size) {
		return gateway.findAll(page, size);
	}

}
