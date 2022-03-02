package com.andrealoisio.repositories;

import com.andrealoisio.entities.ScraperInfo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ScraperInfoRepository implements PanacheRepository<ScraperInfo> {
}
