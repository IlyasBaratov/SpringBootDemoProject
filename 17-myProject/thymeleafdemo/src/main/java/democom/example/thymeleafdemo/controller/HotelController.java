package democom.example.thymeleafdemo.controller;

import democom.example.thymeleafdemo.entity.Hotel;
import democom.example.thymeleafdemo.service.HotelService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/hotels")
public class HotelController {
    HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @RequestMapping("/confirmation")
    public String confirm(){
        return "hotels/confirm";
    }

    @GetMapping("/list")
    public String listHotels(Model model){
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels",hotels);
        return "hotels/list-hotels";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Hotel hotel = new Hotel();
        model.addAttribute("hotel",hotel);
        return "hotels/hotel-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("hotel") Hotel hotel){
        hotelService.save(hotel);
        return "redirect:/hotels/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("hotelId") int hotelId){
        hotelService.deleteById(hotelId);
        return ("redirect:/hotels/list");
    }

}
