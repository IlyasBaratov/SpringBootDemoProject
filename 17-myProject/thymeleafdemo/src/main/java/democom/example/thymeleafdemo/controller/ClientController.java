package democom.example.thymeleafdemo.controller;

import democom.example.thymeleafdemo.entity.Hotel;
import democom.example.thymeleafdemo.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/hotels")
public class ClientController {
    HotelService hotelService;

    @GetMapping("list-for-clients")
    public String listForClient(Model model){
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels",hotels);
        return "hotels/list-clients";
    }
    @GetMapping("/book")
    public String book(@RequestParam("hotelId") int hotelId){
        Hotel hotel = hotelService.findById(hotelId);
        int temp = hotel.getRoomsAvailable();
        hotel.setRoomsAvailable(temp-1);
        hotelService.save(hotel);
        return "redirect:/hotels/list-for-clients";
    }
}
