package com.meetic.controllers;
import com.meetic.models.User;
import com.meetic.models.repositories.UserRepository;
import com.meetic.models.views.UsersEventosView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getUser() {
        logger.info("Sending all users");
        return userRepository.findAll();
    }

    @GetMapping(path = "/inscricoes/", produces= MediaType.APPLICATION_JSON_VALUE )
    public Iterable<UsersEventosView> getInscricoes() {
      logger.info("Sending all inscricoes");
      return userRepository.findAllInscricoes();
    }

    @GetMapping(path="/{userId}/inscricoes", produces= MediaType.APPLICATION_JSON_VALUE )
    public Iterable<UsersEventosView> getIncricoesPlan
                        (@PathVariable int userId) {
      logger.info("Inscricoes by id "+userId);
      return userRepository.findInscricoesById(userId);
    }                      


}
