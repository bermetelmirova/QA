package kg.academy.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;
}

