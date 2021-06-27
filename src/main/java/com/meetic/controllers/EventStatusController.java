package com.meetic.controllers;
import com.meetic.models.EventStatus;
import com.meetic.models.repositories.EventStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/status")
public class EventStatusController {
    private Logger logger = LoggerFactory.getLogger(EventStatusController.class);
    @Autowired
    private EventStatusRepository EventStatusRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EventStatus> getEventStatus() {
        logger.info("Sending all status");
        return EventStatusRepository.findAll();
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EventStatus> getEventStatus (@PathVariable int id) {
        logger.info("status with id "+ id);
        return EventStatusRepository.findStatusById(id);
    }


}
