package dao;

import model.Orc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class OrcImplDAO implements OrcDAO {

    EntityManagerFactory emf = EntityManagerFactoryS.getInstance();
    EntityManager em = null;

    @Override
    public List<Orc> findByRage(String rage) {
        //TODO
        return null;
    }

    @Override
    public List<Orc> findAll() {
        List<Orc> orcs = null;
        try{
            em = emf.createEntityManager();
            orcs =  em.createQuery("select o from Orc o").getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(em != null && em.isOpen()){
                em.close();
            }
        }
        return orcs;
    }

    @Override
    public Orc findById(Long id) {
        Orc orc = null;
        try{
           em = emf.createEntityManager();
           orc = em.find(Orc.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(em != null && em.isOpen()){
                em.close();
            }
        }
        return orc;
    }

    @Override
    public void update(Orc entity) {
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
    public void delete(Orc entity) {
        EntityTransaction tx = null;
        try{
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(entity);
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
    public void deleteByKey(Long id) {
        Orc orc = findById(id);
        if(orc != null){
            delete(orc);
        }
    }

    @Override
    public void create(Orc entity) {
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





