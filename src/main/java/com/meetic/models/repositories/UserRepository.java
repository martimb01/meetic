package com.meetic.models.repositories;
import com.meetic.models.User;
import com.meetic.models.views.UsersEventosView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    String UsersEmEventos =
                "SELECT concat (us_FirstName, us_LastName) as user, U.us_Id as id, "+
                "ev_name as evento " +
                "FROM User U "+
                "INNER JOIN enrolls E ON U.us_Id=E.en_us_Id "+
                "INNER JOIN Event EV ON EV.ev_Id=E.en_ev_Id "+
                "WHERE E.en_participation=1";

    String UsersEmEventosById =
                "SELECT concat (us_FirstName, us_LastName) as user, U.us_Id as id, "+
                "ev_name as evento " +
                "FROM User U "+
                "INNER JOIN enrolls E ON U.us_Id=E.en_us_Id "+
                "INNER JOIN Event EV ON EV.ev_Id=E.en_ev_Id "+
                "WHERE E.en_participation=1 and U.us_Id =:id";
    

    @Query(value=UsersEmEventos,nativeQuery=true)
    Iterable<UsersEventosView> findAllInscricoes();        

    @Query(value=UsersEmEventosById,nativeQuery=true)
    Iterable<UsersEventosView> findInscricoesById(@Param("id") int id);



}
