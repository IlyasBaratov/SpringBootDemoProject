package democom.example.thymeleafdemo.service;



import democom.example.thymeleafdemo.entity.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> findAll();

    Hotel findById(int theId);

    Hotel save(Hotel theEmployee);

    void deleteById(int theId);

}
