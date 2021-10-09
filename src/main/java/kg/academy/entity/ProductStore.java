package kg.academy.entity;
import kg.academy.util.HibernateUtil;
import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "product_store")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getReserve(Long Id) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Product product = hibernateSession.get(Product.class, id);
        hibernateSession.close();
        return product;
    }
    public Long add(Product product) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.save(product);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        return id;
    }
}

