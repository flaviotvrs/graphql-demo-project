package br.com.flaviotvrs.tutorial.dataprovider;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.dataprovider.mapper.BookMapper;
import br.com.flaviotvrs.tutorial.dataprovider.repository.BookRepository;
import br.com.flaviotvrs.tutorial.dataprovider.repository.entity.BookEntity;
import br.com.flaviotvrs.tutorial.usecase.entity.Book;
import br.com.flaviotvrs.tutorial.usecase.gateway.BookFindAllGateway;

@Component
class BookFindAllDataProvider implements BookFindAllGateway {

	private BookRepository repository;

	@Autowired
	public BookFindAllDataProvider(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Book> findAll(int page, int size) {
		Page<BookEntity> findAll = repository.findAll(PageRequest.of(page, size));
		return BookMapper.toBusinessEntity(findAll.get().collect(Collectors.toList()));
	}

}
