package com.cdn.rest;
import javax.swing.JOptionPane;
import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.research.ws.wadl.Response;


@Path("/hello")

public class MyJerseyPage {
	//recebe String(Object(gson) ou String) do OS via POST
	//guarda na memoria conteudo recebido do OS
	@POST
	@Path("/recebeInfoOS")
	public Response recebeInfoDoOS(@FormParam("recurso") String recurso) 
	{
		Gson gson = new Gson();
		SeuObjeto obj = gson.fromJson(recurso, SeuObjeto.class);
		armazena(obj) // armazenar na memoria o obj
		String output = gson.toJson(new Boolean(b));
		// tenho que ver como vai ser esse objeto
		return Response.status(200).entity(output).build();
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "Server: OS;Path: localhost:80/gmalaq/;File: soldado.mp4";
	}
	//recebe solicitação do navegador e faz um refresh
	// para onde o arquivo solicidato esta
	@Path("/hello2")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello2() {
		return "<meta http-equiv='refresh' content='0'; url='http://example.com/' />";
	}
}