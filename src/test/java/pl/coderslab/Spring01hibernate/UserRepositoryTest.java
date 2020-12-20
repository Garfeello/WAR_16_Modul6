package pl.coderslab.Spring01hibernate;

import org.junit.Test;
import pl.coderslab.Spring01hibernate.model.User;
import pl.coderslab.Spring01hibernate.repository.UserRepository;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserRepositoryTest {

    @Test
    public void giveUserDataAndCreate_shouldAddToDatabaseNewUser() {
        UserRepository userRepository = new UserRepository();

        String firstName = "Adam";
        String lastName = "Kowalski";
        String email = "oaskdokasdo@o2.pl";

        int alreadyAddedUsers = userRepository.countUsers();
        userRepository.createNewUser(firstName, lastName, email);
        int afterAddedUserCount = userRepository.countUsers();

        assertEquals(alreadyAddedUsers + 1, afterAddedUserCount);

    }

    @Test
    public void shouldCreateNewUserOnGivenData() {
        UserRepository userRepository = new UserRepository();

        String firstName = "Adam";
        String lastName = "Kowalski";
        String email = "oaskdokasdo@o2.pl";

        userRepository.createNewUser(firstName, lastName, email);
        User user = userRepository.findUserByEmail(email);

        assertNotNull(user);
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
    }

    @Test
    public void shouldReturnNullWhenUserByEmailNotExist() {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findUserByEmail("jakisMail");
        assertNull(user);
    }

    @Test
    public void shouldRemoveUserFromDatabaseOnGivenEmail() {
        UserRepository userRepository = new UserRepository();

        String firstName = "Adam";
        String lastName = "Kowalski";
        String email = "oaskdokasdo@o2.pl";

        userRepository.createNewUser(firstName, lastName, email);
        int alreadyAddedUsers = userRepository.countUsers();
        userRepository.removeUser(email);
        int afterAddedUserCount = userRepository.countUsers();

        assertEquals(alreadyAddedUsers, afterAddedUserCount + 1);
    }

    @Test
    public void shouldEditUserOnGivenEmail() {
        UserRepository userRepository = new UserRepository();

        String firstName = "Adam";
        String lastName = "Kowalski";
        String email = "oaskdokasdo@o2.pl";

        String newFirstName = "Stefan";
        String newLastName = "Nowak";

        userRepository.createNewUser(firstName, lastName, email);
        User user = userRepository.findUserByEmail(email);
        user.setFirstName(newFirstName);
        user.setLastName(newLastName);
        userRepository.updateUser(user);
        User userAfterEdit = userRepository.findUserByEmail(email);

        assertEquals(newFirstName, userAfterEdit.getFirstName());
        assertEquals(newLastName, userAfterEdit.getLastName());
    }

}
