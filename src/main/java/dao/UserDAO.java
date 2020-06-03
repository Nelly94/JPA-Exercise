package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UserDAO implements GenericDAO<User, Long> {

    EntityManagerFactory emf = EntityManagerFactoryS.getInstance();
    EntityManager em = null;

    @Override
    public List<User> findAll() {
        //TODO
        return null;
    }

    @Override
    public User findById(Long id) {
        //TODO
        return null;
    }

    @Override
    public void update(User entity) {
        EntityTransaction tx = null;
        try{
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(entity);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }
        }finally{
            if(em != null && em.isOpen()){
                em.close();
            }
        }

    }

    @Override
    public void delete(User entity) {
        //TODO
    }

    @Override
    public void deleteByKey(Long id) {
        //TODO
    }

    @Override
    public void create(User entity) {
        EntityTransaction tx = null;

        try{
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }

        }finally {
            if(em != null && em.isOpen()){
                em.close();
            }
        }
    }
}
