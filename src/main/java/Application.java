import model.Item;
import model.LevelElementId;
import model.Orc;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args){

        User user = new User("user@gmail.com", "userpass");

        Orc orc = new Orc("Bravatos", 100, 500, 52);
        orc.setRage("Mandolian");
        orc.setUser(user);
        user.getCharacters().add(orc);

        Item sword = new Item(new LevelElementId("flamming sword", 68));
        sword.getCharacters().add(orc);
        orc.getItems().add(sword);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexercise");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        em.persist(user);
        //em.persist(sword);
        //em.persist(orc);

        tx.commit();
        em.close();
    }
}
