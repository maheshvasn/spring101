package org.hk.spring101.repositories;

import org.hk.spring101.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
