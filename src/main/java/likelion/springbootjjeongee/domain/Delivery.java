package likelion.springbootjjeongee.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;
import static likelion.springbootjjeongee.domain.Delivery.DeliveryStatus.ESTABLISHED;

@Entity
@NoArgsConstructor(access=PROTECTED)
@Getter
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy="delivery")
    private Order order;

    @Enumerated(STRING)
    private DeliveryStatus deliveryStatus;

    private String city;
    private String state;
    private String street;
    private String zipcode;

    public static Delivery createDelivery(Order order,String city, String state, String street, String zipcode){
        Delivery delivery = new Delivery();
        delivery.order=order;
        delivery.deliveryStatus=ESTABLISHED;
        delivery.city=city;
        delivery.state=state;
        delivery.street=street;
        delivery.zipcode=zipcode;
        return delivery;
    }

    public enum DeliveryStatus {
        ESTABLISHED, PROGRESS, DONE
    }
}
