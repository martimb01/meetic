package com.meetic.controllers;
import com.meetic.models.EventType;
import com.meetic.models.repositories.EventTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api")
public class EventTypeController {
    private Logger logger = LoggerFactory.getLogger(EventTypeController.class);
    @Autowired
    private EventTypeRepository EventTypeRepository;

    @GetMapping(path = "/types", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EventType> getEventTypes() {
        logger.info("Sending all types of events");
        return EventTypeRepository.findAll();
    }



}
