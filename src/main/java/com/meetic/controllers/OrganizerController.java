package com.meetic.controllers;
import com.meetic.models.Organizer;
import com.meetic.models.repositories.OrganizerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/organizers")
public class OrganizerController {
    private Logger logger = LoggerFactory.getLogger(OrganizerController.class);
    @Autowired
    private OrganizerRepository organizerRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Organizer> getOrganizer() {
        logger.info("Sending all organizers");
        return organizerRepository.findAll();
    }

}