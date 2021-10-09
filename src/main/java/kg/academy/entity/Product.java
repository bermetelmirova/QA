package kg.academy.entity;

import lombok.*;

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
