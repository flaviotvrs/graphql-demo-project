package br.com.flaviotvrs.tutorial.entrypoint;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

import br.com.flaviotvrs.tutorial.entrypoint.mapper.BookMapper;
import br.com.flaviotvrs.tutorial.entrypoint.model.BookResponseModel;
import br.com.flaviotvrs.tutorial.usecase.BookFindByIdUseCase;
import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

	private BookFindByIdUseCase bookUseCase;

	@Autowired
	public GraphQLDataFetchers(BookFindByIdUseCase bookUseCase) {
		this.bookUseCase = bookUseCase;
	}

	private static List<Map<String, String>> authors = Arrays.asList(
			ImmutableMap.of("id", "author-1", "firstName", "Joanne", "lastName", "Rowling"),
			ImmutableMap.of("id", "author-2", "firstName", "Herman", "lastName", "Melville"),
			ImmutableMap.of("id", "author-3", "firstName", "Anne", "lastName", "Rice"));

	public DataFetcher<BookResponseModel> getBookByIdDataFetcher() {
		return dataFetchingEnvironment -> {
			String bookId = dataFetchingEnvironment.getArgument("id");
			return BookMapper.toResponseModel(bookUseCase.findById(bookId));
		};
	}

	public DataFetcher<Map<String, String>> getAuthorDataFetcher() {
		return dataFetchingEnvironment -> {
			BookResponseModel book = dataFetchingEnvironment.getSource();
			String authorId = book.getAuthorId();
			return authors.stream().filter(author -> author.get("id").equals(authorId)).findFirst().orElse(null);
		};
	}
}
