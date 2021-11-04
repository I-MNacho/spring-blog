package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {

                                        //select * from ads where title = :title limit = 1
    Ad findByTitle(String title);       //JPA is going to look through the "Ad" table and find the type title,

    Ad findByDescription(String description);



    //get all ads that the title start with a specific letter
    @Query(nativeQuery = true, value = "SELECT * FROM ads WHERE title LIKE :t%")      //HQL hibernate query language, allows you to input / t = term
    List <Ad> findByTitleLike(@Param("t") String term);
}
