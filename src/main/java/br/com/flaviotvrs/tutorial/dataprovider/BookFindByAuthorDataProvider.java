package br.com.flaviotvrs.tutorial.dataprovider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.dataprovider.mapper.BookMapper;
import br.com.flaviotvrs.tutorial.dataprovider.repository.BookRepository;
import br.com.flaviotvrs.tutorial.usecase.entity.Book;
import br.com.flaviotvrs.tutorial.usecase.gateway.BookFindByAuthorGateway;

@Component
class BookFindByAuthorDataProvider implements BookFindByAuthorGateway {

	private BookRepository repository;

	@Autowired
	public BookFindByAuthorDataProvider(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Book> findByAuthor(Integer authorId) {
		return BookMapper.toBusinessEntity(repository.findByAuthorId(authorId));
	}

}
