package democom.example.thymeleafdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="hotel")
public class Hotel {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    @Column(name="rooms_available")
    private Integer roomsAvailable;

    @Column(name = "price_per_night")
    private Integer pricePerNight;

    public Hotel(String name, String location, Integer roomsAvailable, Integer pricePerNight){
        this.name = name;
        this.location = location;
        this.roomsAvailable = roomsAvailable;
        this.pricePerNight = pricePerNight;
    }


    // define getter/setter

}








