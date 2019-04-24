package br.com.flaviotvrs.tutorial.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.dataprovider.mapper.BookMapper;
import br.com.flaviotvrs.tutorial.dataprovider.repository.BookRepository;
import br.com.flaviotvrs.tutorial.usecase.entity.Book;
import br.com.flaviotvrs.tutorial.usecase.gateway.BookFindByIdGateway;

@Component
class BookFindByIdDataProvider implements BookFindByIdGateway {

	private BookRepository repository;

	@Autowired
	public BookFindByIdDataProvider(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public Book findById(String bookId) {
		return BookMapper.toBusinessEntity(repository.findById(bookId));
	}

}
