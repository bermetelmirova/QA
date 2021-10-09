package kg.academy.entity;
import kg.academy.util.HibernateUtil;
import lombok.*;
import org.hibernate.Session;

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

    public Long create(User user) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.save(user);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("Успешно создан: " + user.toString());
        return user.getId();
    }
}

