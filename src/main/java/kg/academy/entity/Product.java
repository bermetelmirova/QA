package kg.academy.entity;

import kg.academy.util.HibernateUtil;
import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;

}
