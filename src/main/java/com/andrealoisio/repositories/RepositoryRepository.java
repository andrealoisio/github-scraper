package com.andrealoisio.repositories;

import com.andrealoisio.entity.Repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepositoryRepository  implements PanacheRepository<Repository>  {
}
