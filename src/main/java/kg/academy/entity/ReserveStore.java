package kg.academy.entity;

import kg.academy.util.HibernateUtil;
import lombok.*;
import org.hibernate.Session;

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

    public Reserve getReserve(Long Id) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Reserve reserve = hibernateSession.get(Reserve.class, id);
        hibernateSession.close();
        return reserve;
    }
    public Long add(Reserve reserve) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.save(reserve);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        return id;
    }
}
