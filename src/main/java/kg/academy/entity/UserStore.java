package kg.academy.entity;

import kg.academy.util.HibernateUtil;
import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "user_store")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser(Long id) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        User user = hibernateSession.get(User.class, id);
        hibernateSession.close();
        return user;
    }

    public Long add(User user) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.save(user);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        return id;
    }
}
