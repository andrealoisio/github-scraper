
package com.andrealoisio.entities;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;

@Entity
@Table(name = "repositories")
@Indexed
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repositorySeq")
    @SequenceGenerator(name = "repositorySeq", sequenceName = "sq_repository", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @FullTextField(analyzer = "description")
    private String description;
    
    private Boolean fork;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "html_url")
    private String htmlUrl;

    @Column(name = "repository_id")
    private Long repositoryId;
    
    private String name;

    @Column(name = "node_id")
    private String nodeId;

    @Column(name = "is_private")
    private Boolean isPrivate;
    
    private String url;

    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Long getRepositoryIdId() {
        return repositoryId;
    }

    public void setRepositoryIdId(Long repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
