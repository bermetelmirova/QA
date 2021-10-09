package kg.academy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reserve_store")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ReserveStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "reserve_id")
    private Reserve reserve;
}
