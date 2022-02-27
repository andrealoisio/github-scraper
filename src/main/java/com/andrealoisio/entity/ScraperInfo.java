package com.andrealoisio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scraper_info")
public class ScraperInfo {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;

    @Column(name = "last_stored_id")
    private Long lastStoredId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getLastStoredId() {
        return lastStoredId;
    }

    public void setLastStoredId(Long lastStoredId) {
        this.lastStoredId = lastStoredId;
    }
}
