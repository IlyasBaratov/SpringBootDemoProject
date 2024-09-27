package democom.example.thymeleafdemo.dao;


import democom.example.thymeleafdemo.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    // that's it ... no need to write any code LOL!



    // add a methos to sort by a last name
    public List<Hotel> findAllByOrderByNameAsc();

}
