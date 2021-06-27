
package com.meetic.models.repositories;
import com.meetic.models.Event;
import com.meetic.models.views.EventTypeView;
import com.meetic.models.views.EventView;

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



    String QueryFindStatus = 
    "SELECT ma_ev_id as 'Id', ev_name as 'Evento' , ma_es_Id as 'Status' " +
    "FROM Event E INNER JOIN Manages M ON M.ma_ev_Id = E.ev_Id " +
    "Where M.ma_es_id = :id";

    @Query (value = QueryFindStatus, nativeQuery = true)
    Iterable<EventView> findEventByStatus(@Param ("id") int id);


}


