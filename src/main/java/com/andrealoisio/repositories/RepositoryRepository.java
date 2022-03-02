package com.andrealoisio.repositories;

import com.andrealoisio.entities.Repository;
import com.andrealoisio.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RepositoryRepository  implements PanacheRepository<Repository>  {

    public List<Repository> findByUserId(Long userId) {
        return list("userId", userId);
    }
}
