package cloudlion.service.user;

import java.util.Collection;
import java.util.Optional;

import cloudlion.database.User;
import cloudlion.database.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
