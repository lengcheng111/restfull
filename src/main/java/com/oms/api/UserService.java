package com.oms.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public final class UserService {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Greeting hello() {
		return new Greeting("welcome uber jar!");
	}
}
