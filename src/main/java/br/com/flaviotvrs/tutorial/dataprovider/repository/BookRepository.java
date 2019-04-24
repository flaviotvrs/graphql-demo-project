package br.com.flaviotvrs.tutorial.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flaviotvrs.tutorial.dataprovider.repository.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, String> {

}
