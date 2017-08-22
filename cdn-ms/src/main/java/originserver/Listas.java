package originserver;

import java.util.ArrayList;

import edgeserver.InfES;

public class Listas{
	   private static Listas instance = null;
	   public static ArrayList<Arquivo> listaArquivosOS;
	   public static ArrayList<Arquivo> listaArquivosES;
	   public static ArrayList<InfES> listaES;
	   
	   private Listas(){
	   }
	   
	   public static Listas getInstance(){
	         if(instance == null){
	               instance = new Listas();
	               listaArquivosOS = new ArrayList<Arquivo>();
	               listaArquivosES = new ArrayList<Arquivo>();
	               listaES = new ArrayList<InfES>();
	         }
	        return instance;
	   }
}