
package com.meetic.models.repositories;
import com.meetic.models.Event;
import com.meetic.models.views.EventTypeView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends CrudRepository<Event, Integer> {
    String findEventTypeById = 

    "SELECT et_Id AS NumeroCategoria, " + 
    "et_Category AS NomeCategoria, " + 
    "ev_Id as NumeroEvento, " + 
    "ev_Name as NomeEvento, " +
    "ev_Description as DescricaoEvento " + 
    "FROM Event_type ET " + 
    "INNER JOIN Event E ON E.ev_EvType_Id = et_Id " +
    "WHERE ET.et_Id = :ev_EvType_Id";
    
    @Query(value = findEventTypeById, nativeQuery = true)
    Iterable<EventTypeView> findEventTypeById(@Param("ev_EvType_Id") int id);
}


