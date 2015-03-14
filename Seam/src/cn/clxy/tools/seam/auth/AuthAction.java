package cn.clxy.tools.seam.auth;

import static org.jboss.seam.ScopeType.SESSION;

import javax.persistence.NoResultException;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.security.Identity;

import cn.clxy.tools.core.auth.service.UserService;
import cn.clxy.tools.core.common.domain.User;

@Name("authenticator")
public class AuthAction {

    @In
    Identity identity;

    @In
    UserService userService;

    @Out(required = false, scope = SESSION)
    User user;

    public boolean authenticate() {

        String userName = identity.getCredentials().getUsername();
        String password = identity.getCredentials().getPassword();

        try {
            user = userService.login(userName, password);
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }
}
