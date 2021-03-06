package client.controller;

import javax.ws.rs.core.Response.Status;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;

import serialitation.Usuario;
import util.RestauranteException;



public class RegistroController {
	
private WebTarget webTarget;
	
	public RegistroController(WebTarget webTarget) {
		this.webTarget=webTarget;
	}
	
	/**
	 * registrar a un usuario
	 * @param u
	 * @throws RestauranteException
	 */
	public void registrar(Usuario u) throws RestauranteException {
		WebTarget webTarget = this.webTarget.path("restaurante/registro");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RestauranteException("" + response.getStatus());
		}
	}

}
