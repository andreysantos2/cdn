package com.cdn.rest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
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

import edgeserver.InfES;
import originserver.Arquivo;
import originserver.GetLocationExample;
import originserver.Listas;
import originserver.ServerLocation;

@Path("/")

public class MyJerseyPage {
	//recebe String(Object(gson) ou String) do OS via POST
	//guarda na memoria conteudo recebido do OS
	//Teste Comentario TCC MAyara e Renan
	Listas lista = Listas.getInstance();
	Arquivo arquivo = new Arquivo();
	@POST
	@Path("/enviaObjArquivo")
	public Response recebeInfoDoOS(@FormParam("recurso") String recurso) 
	{
		Gson gson = new Gson();
		Arquivo obj = gson.fromJson(recurso, Arquivo.class);
		lista.listaArquivosOS.add(obj); // armazenar na memoria o obj
		System.out.println(lista.listaArquivosOS.size()+"\nCod:"+obj.getId());
		return null;
	}
	@GET
	@Path("/mostraArquivo")
	public String mostraArquivo(@QueryParam("cod") String cod) throws NumberFormatException, URISyntaxException{
		int i = -1;
		for(int j = 0; j<lista.listaArquivosOS.size(); j++){
			if(lista.listaArquivosOS.get(j).getId()==Integer.parseInt(cod)){
				i = j;
			}
		}
		//rastrea cidade pelo ip do cliente
		HttpServletRequest req = null;
		String ipAddress = null;
			ipAddress = req.getHeader("X-FORWARDED-FOR");
			if (ipAddress == null) {
				ipAddress = req.getHeader("X_FORWARDED_FOR");
				if (ipAddress == null){
					ipAddress = req.getRemoteAddr();
		    	}
			}
		
		System.out.println(ipAddress);
		GetLocationExample obj = new GetLocationExample();
		ServerLocation location = obj.getLocation(ipAddress);
		System.out.println(location.getCity());
		//verifica se o ip do request é de SP
		Arquivo arq = lista.listaArquivosOS.get(i);
		if(location.getCity().equals("Sao Paulo")){
			//procura arquivo no ES
			for(int j = 0; j<lista.listaArquivosES.size(); j++){
				if(lista.listaArquivosOS.get(i).getId()==lista.listaArquivosOS.get(j).getId()){
					arq = lista.listaArquivosES.get(i);
				}
			}
			//se não encontra o arquivo envia solicitação para o ES baixar o arquivo
			if(arq.getNome().equals(lista.listaArquivosOS.get(i).getNome())){
				lista.listaArquivosES.add(lista.listaArquivosOS.get(i));
			}
		}
		String html = "<html><head><title>MS</title></head><body>";
		String arquivo = arq.getHost()+arq.getNome();
		if(arq.getExtensao().equals("jpg")||arq.getExtensao().equals("png")||arq.getExtensao().equals("jpeg")||arq.getExtensao().equals("gif")){
			html += "<img src='"+arquivo+"' height='500' width='500'><br>";
		}else if(arq.getExtensao().equals("mp4")||arq.getExtensao().equals("avi")||arq.getExtensao().equals("wmv")){
			html += "<video width='320' height='240' controls><source src='"+arquivo+"' type='video/"+arq.getExtensao()+"'></video><br>";
		}else if(arq.getExtensao().equals("txt")){
			html += "<textarea rows='20' cols='60'>"+arquivo+"</textarea>";
		}else{
			html += "<a href='"+arquivo+"'>"+arquivo+"</a>";
		}
		html += "</body></html>";
		return html;
	}
	//Comunicação com o ES
	@POST
	@Path("/enviaInfCPUES")
	public Response recebeInfoCPUDoES(@FormParam("es") String es) 
	{
		Gson gson = new Gson();
		InfES obj = gson.fromJson(es, InfES.class);
		if(lista.listaES.size()>0)
			lista.listaES.remove(0);
		lista.listaES.add(obj);
		System.out.println(obj.getServer());
		return null;
	}
	@POST
	@Path("/enviaInfArquivoES")
	public Response recebeInfoArquivoDoES(@FormParam("cod") String cod) 
	{
		Gson gson = new Gson();
		Arquivo obj = gson.fromJson(cod, Arquivo.class);
		System.out.println("Atualiza inf do Arquivo: "+obj.getId());
		for(int i = 0; i<Listas.listaArquivosES.size(); i++){
			if(obj.getId()==lista.listaArquivosES.get(i).getId()){
				lista.listaArquivosES.get(i).setId(1);
			}
		}
		return null;
	}
}