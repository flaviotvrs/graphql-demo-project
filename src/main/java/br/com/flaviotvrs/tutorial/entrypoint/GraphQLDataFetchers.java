package br.com.flaviotvrs.tutorial.entrypoint;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.flaviotvrs.tutorial.entrypoint.mapper.BookMapper;
import br.com.flaviotvrs.tutorial.entrypoint.model.BookResponseModel;
import br.com.flaviotvrs.tutorial.usecase.AuthorFindByIdUseCase;
import br.com.flaviotvrs.tutorial.usecase.BookFindByIdUseCase;
import br.com.flaviotvrs.tutorial.usecase.BookFindByNameUseCase;
import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

	private BookFindByIdUseCase bookByIdUseCase;
	private BookFindByNameUseCase bookByNameUseCase;
	private AuthorFindByIdUseCase authorUseCase;

	@Autowired
	public GraphQLDataFetchers(BookFindByIdUseCase bookByIdUseCase, BookFindByNameUseCase bookByNameUseCase,
			AuthorFindByIdUseCase authorUseCase) {
		this.bookByIdUseCase = bookByIdUseCase;
		this.bookByNameUseCase = bookByNameUseCase;
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
			String authorId = book.getAuthorId();
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
}
