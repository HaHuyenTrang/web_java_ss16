package ra.ss16.service;

import ra.ss16.model.User;

public interface UserService {
    void save(User user);
    User findByUsernameAndPassword(String username, String password);
}
