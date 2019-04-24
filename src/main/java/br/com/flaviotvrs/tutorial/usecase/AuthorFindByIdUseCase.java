package br.com.flaviotvrs.tutorial.usecase;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

@Component
public class AuthorFindByIdUseCase {

	private static List<Map<String, String>> authors = Arrays.asList(
			ImmutableMap.of("id", "author-1", "firstName", "Joanne", "lastName", "Rowling"),
			ImmutableMap.of("id", "author-2", "firstName", "Herman", "lastName", "Melville"),
			ImmutableMap.of("id", "author-3", "firstName", "Anne", "lastName", "Rice"),
			ImmutableMap.of("id", "author-4", "firstName", "Stephen", "lastName", "King"));

	public Map<String, String> findById(String authorId) {
		return authors.stream().filter(author -> author.get("id").equals(authorId)).findFirst().orElse(null);
	}

}
