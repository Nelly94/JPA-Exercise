package dao;

import model.Item;
import model.LevelElementId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ItemDAO implements GenericDAO<Item, LevelElementId> {

    EntityManagerFactory emf = EntityManagerFactoryS.getInstance();
    EntityManager em = null;


    @Override
    public List<Item> findAll() {
        //TODO
        return null;
    }

    @Override
    public Item findById(LevelElementId id) {
        //TODO
        return null;
    }

    @Override
    public void update(Item entity) {
        //TODO

    }

    @Override
    public void delete(Item entity) {
        //TODO

    }

    @Override
    public void deleteByKey(LevelElementId id) {
        //TODO

    }

    @Override
    public void create(Item entity) {
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
