package com.meetic.models.repositories;

import com.meetic.models.EventStatus;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EventStatusRepository extends CrudRepository<EventStatus, Integer> {


    Iterable<EventStatus> findEventStatusById(@Param ("id") int id);

}

