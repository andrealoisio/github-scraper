package com.andrealoisio.rest.client;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

@ApplicationScoped
public class RestClientHeaderFactory implements ClientHeadersFactory {

    final static String UNAUTHENTICATED = "unauthenticated";

    @ConfigProperty(name = "github.api-token")
    String githubToken;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> multivaluedMap, MultivaluedMap<String, String> multivaluedMap1) {
        MultivaluedMap<String, String> result = new MultivaluedHashMap<>();
        if (!githubToken.equals(UNAUTHENTICATED)) {
            result.add("Authorization", "token " + githubToken);
        }
        return result;
    }

}
