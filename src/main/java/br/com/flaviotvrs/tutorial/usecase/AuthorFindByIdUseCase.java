package br.com.flaviotvrs.tutorial.usecase;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthorFindByIdUseCase {

	private static List<Map<String, String>> authors = Arrays.asList(
			ImmutableMap.of("id", "1", "firstName", "Joanne", "lastName", "Rowling"),
			ImmutableMap.of("id", "2", "firstName", "Herman", "lastName", "Melville"),
			ImmutableMap.of("id", "3", "firstName", "Anne", "lastName", "Rice"),
			ImmutableMap.of("id", "4", "firstName", "Stephen", "lastName", "King"));

	public Map<String, String> findById(Integer authorId) {
		log.debug("Finding author by ID '{}'", authorId);
		return authors.stream().filter(author -> Integer.valueOf(author.get("id")).equals(authorId)).findFirst()
				.orElse(null);
	}

}
