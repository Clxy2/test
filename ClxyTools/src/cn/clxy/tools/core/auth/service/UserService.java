package cn.clxy.tools.core.auth.service;

import cn.clxy.tools.core.common.domain.User;

/**
 * User service.
 * @author clxy
 */
public interface UserService {

    /**
     * Do authentication.<br>
     * @param id
     * @param password
     * @return
     */
    User login(String id, String password);
}
