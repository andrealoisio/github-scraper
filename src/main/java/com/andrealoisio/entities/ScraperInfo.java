package com.andrealoisio.entities;

import javax.persistence.*;

@Entity
@Table(name = "scraper_info")
public class ScraperInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "last_repo_id")
    private Long lastRepoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLastRepoId() {
        return lastRepoId;
    }

    public void setLastRepoId(Long lastRepoId) {
        this.lastRepoId = lastRepoId;
    }
}
