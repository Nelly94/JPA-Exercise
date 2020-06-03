import dao.ItemDAO;
import dao.OrcImplDAO;
import dao.UserDAO;
import model.Item;
import model.LevelElementId;
import model.Orc;
import model.User;

public class Application {

    public static void main(String[] args){

        UserDAO userDao = new UserDAO();
        OrcImplDAO orcDao = new OrcImplDAO();
        ItemDAO itemDao = new ItemDAO();

        //Create users
        User user1 = new User("user1@gmail.com", "user1");
        userDao.create(user1);

        User user2 = new User("user2@gmail.com", "user2");
        userDao.create(user2);

        //Create orc
        Orc bravatos = new Orc("Bravatos", 100, 500, 52);
        bravatos.setUser(user1);
        orcDao.create(bravatos);
        //Update user to add orc as its character
        user1.getCharacters().add(bravatos);
        userDao.update(user1);

        //Create item
        Item sword = new Item(new LevelElementId("flamming sword", 68));
        itemDao.create(sword);
        //Update character
        bravatos.getItems().add(sword);
        orcDao.update(bravatos);
        //Update item
        //sword.getCharacters().add(bravatos);
        //itemDao.update(sword);
    }
}
