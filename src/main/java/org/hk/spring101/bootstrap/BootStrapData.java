package org.hk.spring101.bootstrap;

import org.hk.spring101.domain.Author;
import org.hk.spring101.domain.Book;
import org.hk.spring101.domain.Publisher;
import org.hk.spring101.repositories.AuthorRepository;
import org.hk.spring101.repositories.BookRepository;
import org.hk.spring101.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author vyas = new Author("Veda", "Vyas");
    Book bhag = new Book("Bhagavatam", "111111");
    Publisher bbt = new Publisher("BBT", "Watseka Ave", "Los Angeles", "CA", 90034);

    publisherRepository.save(bbt);

    vyas.getBooks().add(bhag);
    bhag.getAuthors().add(vyas);
    bhag.setPublisher(bbt);
    bbt.getBooks().add(bhag);

    authorRepository.save(vyas);
    bookRepository.save(bhag);
    publisherRepository.save(bbt);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of Authors" + authorRepository.count());
    System.out.println("Number of Books" + bookRepository.count());
    System.out.println("Number of publishers" + publisherRepository.count());
  }
}
