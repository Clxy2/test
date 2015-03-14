package cn.clxy.tools.core.auth.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cn.clxy.tools.core.auth.service.UserService;
import cn.clxy.tools.core.common.domain.User;

public class UserServiceJPAImpl implements UserService {

    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public User login(String id, String password) {

        Query query = em.createNamedQuery("user.login");
        query.setParameter("email", id);
        query.setParameter("password", password);

        return (User) query.getSingleResult();
    }

}
