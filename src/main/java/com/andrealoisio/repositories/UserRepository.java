package com.andrealoisio.repositories;

import com.andrealoisio.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public List<User> findByUserId(List<Long> userIds) {
        return list("userId in ?1", userIds);
    }

}
