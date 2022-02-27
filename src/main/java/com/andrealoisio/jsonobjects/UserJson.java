
package com.andrealoisio.jsonobjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserJson {

    @JsonProperty("avatar_url")
    private String avatarUrl;

    private Object bio;

    private String blog;

    private Object company;
    @JsonProperty("created_at")
    private String createdAt;

    private Object email;
    @JsonProperty("events_url")
    private String eventsUrl;

    private Long followers;
    @JsonProperty("followers_url")
    private String followersUrl;

    private Long following;
    @JsonProperty("following_url")
    private String followingUrl;
    @JsonProperty("gists_url")
    private String gistsUrl;
    @JsonProperty("gravatar_id")
    private String gravatarId;

    private Object hireable;
    @JsonProperty("html_url")
    private String htmlUrl;

    private Long id;

    private Object location;

    private String login;

    private String name;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("organizations_url")
    private String organizationsUrl;
    @JsonProperty("public_gists")
    private Long publicGists;
    @JsonProperty("public_repos")
    private Long publicRepos;
    @JsonProperty("received_events_url")
    private String receivedEventsUrl;
    @JsonProperty("repos_url")
    private String reposUrl;
    @JsonProperty("site_admin")
    private Boolean siteAdmin;
    @JsonProperty("starred_url")
    private String starredUrl;
    @JsonProperty("subscriptions_url")
    private String subscriptionsUrl;
    @JsonProperty("twitter_username")
    private Object twitterUsername;

    private String type;
    @JsonProperty("updated_at")
    private String updatedAt;

    private String url;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public Object getHireable() {
        return hireable;
    }

    public void setHireable(Object hireable) {
        this.hireable = hireable;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public Long getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(Long publicGists) {
        this.publicGists = publicGists;
    }

    public Long getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(Long publicRepos) {
        this.publicRepos = publicRepos;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public Object getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(Object twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}