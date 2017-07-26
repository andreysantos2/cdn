package originserver;

import java.util.ArrayList;

public class Lista{
	   private static Lista instance = null;
	   public static ArrayList<Arquivo> listaArquivos;

	   private Lista(){
	   }
	   
	   public static Lista getInstance(){
	         if(instance == null){
	               instance = new Lista();
	               listaArquivos = new ArrayList<Arquivo>();
	         }
	        return instance;
	   }
}