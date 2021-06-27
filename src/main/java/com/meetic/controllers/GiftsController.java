package com.meetic.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meetic.models.Gifts;
import com.meetic.models.repositories.GiftsRepository;
import com.meetic.models.views.GiftsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path="/api/gifts")
public class GiftsController {
    private Logger logger = LoggerFactory.getLogger(GiftsController.class);
    @Autowired
    private GiftsRepository giftsRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Gifts> getGifts() {
        logger.info("Sending all gifts");
        return giftsRepository.findAll();
    }

    
    @GetMapping(path="/{id}/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GiftsView> getEventStatus (@PathVariable int id) {
        logger.info("Plans of unit with id "+ id);
        return giftsRepository.findUserGiftsById(id);
    }
    
}