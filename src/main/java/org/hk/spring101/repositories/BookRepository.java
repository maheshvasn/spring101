package org.hk.spring101.repositories;

import org.hk.spring101.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
