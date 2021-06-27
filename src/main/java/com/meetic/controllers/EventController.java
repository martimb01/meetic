package com.meetic.controllers;
import com.meetic.models.Event;
import com.meetic.models.repositories.EventRepository;
import com.meetic.models.views.EventTypeView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/events")
public class EventController {
    private Logger logger = LoggerFactory.getLogger(EventController.class);
    
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Event> getEvent() {
        logger.info("Sending all events");
        return eventRepository.findAll();
    }
    @Autowired
    private EventRepository eventRepository;

    @GetMapping(path = "/types/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EventTypeView> getEventType(@PathVariable int id) {
        logger.info("Sending one type of event" + id);
        return eventRepository.findEventTypeById(id);
    }

}
