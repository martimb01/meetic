package com.meetic.models.repositories;
import com.meetic.models.Gifts;
import com.meetic.models.views.GiftsView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GiftsRepository extends CrudRepository<Gifts, Integer> {

    String QueryFindUserGifts = 
    "SELECT concat (us_FirstName, us_LastName) as 'Nome', gi_Name as 'Premio' " +
    "FROM User U INNER JOIN Redeems R ON R.re_us_Id = U.us_Id "+
	"INNER JOIN Gifts GIF ON R.re_gi_Id = GIF.gi_Id " +
    "Where U.us_Id = :id";

    @Query (value = QueryFindUserGifts, nativeQuery = true)
    Iterable<GiftsView> findUserGiftsById(@Param ("id") int id);

    

}

