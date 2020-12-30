package org.hk.spring101.controllers;

import org.hk.spring101.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

  private AuthorRepository authorRepository;

  AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @RequestMapping("/authors")
  public String getAuthors(Model model) {

    model.addAttribute("authors", authorRepository.findAll());
    return "authors";
  }
}
