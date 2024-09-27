package democom.example.thymeleafdemo.service;

import democom.example.thymeleafdemo.dao.HotelRepository;
import democom.example.thymeleafdemo.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Hotel findById(int id) {
        Optional<Hotel> result = hotelRepository.findById(id);

        Hotel hotel = null;

        if (result.isPresent()) {
            hotel = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find hotel id - " + id);
        }

        return hotel;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteById(int id) {
        hotelRepository.deleteById(id);
    }
}






