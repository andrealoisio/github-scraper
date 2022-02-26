package com.andrealoisio.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Path;

@Path("/")
@RegisterRestClient(configKey = "repositories-api")
public interface RepositoryRestClient {

}
