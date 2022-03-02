package com.andrealoisio.repositories;

import com.andrealoisio.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public List<User> findByUserId(List<Long> userIds) {
        return list("userId in ?1", userIds);
    }

    public User findByUsername(String username) {
        return find("login", username).firstResult();
    }

}
