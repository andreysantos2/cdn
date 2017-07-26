package originserver;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(final String[] args) throws Exception {
		
		ArrayList<Arquivo> listaArquivos = new ArrayList<Arquivo>();
		//Arquivo arquivo = new Arquivo();

		while(true){
			Pasta p = new Pasta();
			ArrayList<File> files = p.listFiles(new File ("c:\\users\\rodrigo\\desktop\\nginx\\default"));
        
        	for (File f : files) {
        		Arquivo arquivo = new Arquivo();
        		//System.out.println (f.getName());
        		//lerPasta.add(f.getAbsolutePath());
        		arquivo.setNome(f.getAbsolutePath());
        	try{
        		arquivo.setExtensao(f.getAbsolutePath().split(".")[0]);
        		
        	}catch(Exception e){
        		arquivo.setExtensao("Pasta");
        		//System.out.println(arquivo.getExtensao());
        	}
        		System.out.println(arquivo.getExtensao());
        		if(arquivo.getNome().equals(f.getAbsolutePath())){
        		System.out.println("Ja add");
        		}
        		listaArquivos.add(arquivo);
        	}
        Thread.sleep(1000);	
        }	
    }
}
		
	