package cloudlion.service.currentuser;

import cloudlion.database.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
