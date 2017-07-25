package OrigemServer;

import java.io.File;
import java.util.*;
import java.io.IOException;


public class VisualizarArquivo {
	
	public String pasta;
	String diretorio = "c:\\simtk";
	ArrayList<String> listaPastas = new ArrayList<String>();
	ArrayList<String> listaArquivos = new ArrayList<String>();

	public void visualizarArquivos() throws IOException, Exception {
	//while(true){
					File file = new File(diretorio);
					File afile[] = file.listFiles();
					//listar diretorio pesquisar metodo
					int i = 0;
					
		
		
		for (int j = afile.length; i < j; i++) {
					File arquivos = afile[i];
			
				if(arquivos.isDirectory()){
					File arquivos1 = afile[i];
					//listaPastas.add(arquivos.getName());
					pesquisaPasta(diretorio);
					//File arquivos1 = afile[i];
					//listaArquivos.add(arquivos1.getName());
					//System.out.println(arquivos1.getName());
				}
					else{
					listaArquivos.add(arquivos.getName());
			//System.currentTimeMillis()
			//Thread.sleep(1000);
			}
		//}	
	}
}
	
	public boolean pesquisaPasta(String pasta){
		//Scanner in = new Scanner(System.in);
		//System.out.println("Digite o caminho do arquivo: ");
		//String caminho = in.nextLine();
		
		File pasta1 = new File(pasta);
		File pasta2[] = pasta1.listFiles();
		int i=0;
		
		for(int j = pasta2.length; i<j; i++){
			File arquivo = pasta2[i];
			System.out.println(arquivo.getName());
			listaArquivos.add(arquivo.getName());
			//listaArquivos.set(i, caminho);
		}
		
		
		return true;
	}
	
	public boolean pesquisaArquivo(String arquivo){
	return true;
	}
}