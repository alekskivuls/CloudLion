package cloudlion.service.user;

import java.util.Collection;
import java.util.Optional;

import cloudlion.domain.User;
import cloudlion.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
