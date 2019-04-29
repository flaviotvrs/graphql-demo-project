package br.com.flaviotvrs.tutorial.entrypoint;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.entrypoint.mapper.BookMapper;
import br.com.flaviotvrs.tutorial.entrypoint.model.BookResponseModel;
import br.com.flaviotvrs.tutorial.usecase.AuthorFindByIdUseCase;
import br.com.flaviotvrs.tutorial.usecase.BookFindAllUseCase;
import br.com.flaviotvrs.tutorial.usecase.BookFindByAuthorUseCase;
import br.com.flaviotvrs.tutorial.usecase.BookFindByIdUseCase;
import br.com.flaviotvrs.tutorial.usecase.BookFindByNameUseCase;
import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

	private BookFindByIdUseCase bookByIdUseCase;
	private BookFindByNameUseCase bookByNameUseCase;
	private BookFindByAuthorUseCase bookByAuthorUseCase;
	private BookFindAllUseCase bookFindAllUseCase;
	private AuthorFindByIdUseCase authorUseCase;

	@Autowired
	public GraphQLDataFetchers(BookFindByIdUseCase bookByIdUseCase, BookFindByNameUseCase bookByNameUseCase,
			BookFindByAuthorUseCase bookByAuthorUseCase, BookFindAllUseCase bookFindAllUseCase,
			AuthorFindByIdUseCase authorUseCase) {
		this.bookByIdUseCase = bookByIdUseCase;
		this.bookByNameUseCase = bookByNameUseCase;
		this.bookByAuthorUseCase = bookByAuthorUseCase;
		this.bookFindAllUseCase = bookFindAllUseCase;
		this.authorUseCase = authorUseCase;
	}

	public DataFetcher<BookResponseModel> getBookByIdDataFetcher() {
		return dataFetchingEnvironment -> {
			String bookId = dataFetchingEnvironment.getArgument("id");
			return BookMapper.toResponseModel(bookByIdUseCase.findById(bookId));
		};
	}

	public DataFetcher<Map<String, String>> getAuthorDataFetcher() {
		return dataFetchingEnvironment -> {
			BookResponseModel book = dataFetchingEnvironment.getSource();
			Integer authorId = book.getAuthorId();
			return authorUseCase.findById(authorId);
		};
	}

	public DataFetcher<List<BookResponseModel>> getBookByNameDataFetcher() {
		return dataFetchingEnvironment -> {
			String bookName = dataFetchingEnvironment.getArgument("name");
			return BookMapper.toResponseModel(bookByNameUseCase.findByName(bookName));
		};
	}

	public DataFetcher<Integer> getBookPageCountDataFetcher() {
		return dataFetchingEnvironment -> {
			BookResponseModel book = dataFetchingEnvironment.getSource();
			return book.getPageCount();
		};
	}

	public DataFetcher<List<BookResponseModel>> getBookByAuthorDataFetcher() {
		return dataFetchingEnvironment -> {
			Integer authorId = dataFetchingEnvironment.getArgument("author_id");
			return BookMapper.toResponseModel(bookByAuthorUseCase.findByAuthor(authorId));
		};
	}

	public DataFetcher<List<BookResponseModel>> getAllBooksDataFetcher() {
		return dataFetchingEnvironment -> {
			Integer page = dataFetchingEnvironment.getArgument("page");
			Integer size = dataFetchingEnvironment.getArgument("size");
			return BookMapper.toResponseModel(bookFindAllUseCase.findAll(page, size));
		};
	}
}
