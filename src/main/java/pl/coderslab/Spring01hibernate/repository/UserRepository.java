package pl.coderslab.Spring01hibernate.repository;

import pl.coderslab.Spring01hibernate.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<Integer, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public int countUsers() {
        return users.values().size();
    }

    public void createNewUser(String firstName, String lastName, String email) {
        User user = new User(firstName, lastName, email);
        users.put(users.keySet().size(), user);
    }

    public User findUserByEmail(String email) {
        return users.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public void removeUser(String email) {
        users.values().removeIf(u -> u.getEmail().equals(email));
    }

    public void updateUser(User user) {
        users.entrySet().stream()
                .filter(entry -> entry.getValue().getEmail().equals(user.getEmail()))
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(key -> users.replace(key, user));
    }

}
