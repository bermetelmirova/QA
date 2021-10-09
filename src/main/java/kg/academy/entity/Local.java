package kg.academy.entity;

import kg.academy.util.HibernateUtil;
import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "local")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "reserve_store_id")
    private ReserveStore reserveStore;
    @OneToOne
    @JoinColumn(name = "product_store_id")
    private ProductStore productStore;
    @OneToOne
    @JoinColumn(name = "user_store_id")
    private UserStore userStore;

    public void reserve(Long idUser, Long idProduct){
        Reserve reserve = hibernateSession
                .createQuery("select r FROM Reserve r where r.product.id =:idP and r.user.id=:idU", Reserve.class)
                .setParameter("idP", idProduct)
                .setParameter("idU", idUser)
                .uniqueResult();
        System.out.println(reserve);
    }
    private static final Session hibernateSession =
            HibernateUtil.getSessionFactory().openSession();
    public  List<Local> read() {
        List<Local> employees = hibernateSession.createQuery("FROM Local", Local.class).list();
        System.out.println("Find " + employees.size() + " employees");
        return employees;
    }

    public Long create(Local local) {
        hibernateSession.beginTransaction();
        hibernateSession.save(local);
        hibernateSession.getTransaction().commit();

        System.out.println("Успешно создан: " + local.toString());
        return local.getId();
    }

    public Local update(Local employee) {
        hibernateSession.beginTransaction();
        Local em = hibernateSession.get(Local.class, employee.getId());
        em.setProductStore(employee.getProductStore());
        em.setReserveStore(employee.getReserveStore());
        em.setUserStore(employee.getUserStore());
        hibernateSession.getTransaction().commit();

        return em;
    }

    public void delete(Long id) {
        hibernateSession.beginTransaction();
        Local e = findById(id);
        hibernateSession.delete(e);
        hibernateSession.getTransaction().commit();
        System.out.println("DELETED " + e.getId());
    }
    public Local findById(Long id) {
        Local e = hibernateSession.get(Local.class, id);
        return e;
    }
}
