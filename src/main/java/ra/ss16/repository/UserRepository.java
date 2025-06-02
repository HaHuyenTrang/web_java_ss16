package ra.ss16.repository;

import ra.ss16.model.User;

public interface UserRepository {
    void save(User user);
    User findByUsernameAndPassword(String username, String password);
}
