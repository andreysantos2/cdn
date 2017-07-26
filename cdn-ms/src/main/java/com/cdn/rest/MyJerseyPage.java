package com.cdn.rest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;
import originserver.Arquivo;
import originserver.Lista;

@Path("/")

public class MyJerseyPage {
	//recebe String(Object(gson) ou String) do OS via POST
	//guarda na memoria conteudo recebido do OS
	//Teste Comentario TCC MAyara e Renan
	Lista lista = Lista.getInstance();
	Arquivo arquivo = new Arquivo();
	@POST
	@Path("/enviaObjArquivo")
	public Response recebeInfoDoOS(@FormParam("recurso") String recurso) 
	{
		Gson gson = new Gson();
		Arquivo obj = gson.fromJson(recurso, Arquivo.class);
		System.out.println(obj.getNome());
		lista.listaArquivos.add(obj); // armazenar na memoria o obj
		System.out.println(lista.listaArquivos.size());
		return null;
	}
	@POST
	@Path("/mostraArquivo")
	public Response mostraArquivo(@FormParam("i") String i) throws NumberFormatException, URISyntaxException{
		return Response.status(303).entity(new URI(lista.listaArquivos.get(Integer.parseInt("2")).getNome())).build();
	}
}