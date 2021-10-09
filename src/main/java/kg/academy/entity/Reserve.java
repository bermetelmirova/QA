package kg.academy.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserve")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "reserve_date", nullable = false)
    private LocalDateTime reserveDate;
    @Column(name = "alarm_date", nullable = false)
    private LocalDateTime alarmDate;
    private Integer state;
    @ManyToOne
    @JoinColumn(name= "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name= "product_id", nullable = false)
    private Product product;

    public Reserve(User user, Product product){
        this.user = user;
        this.product = product;
    }
}
