package originserver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pasta extends Arquivo {
	
	ArrayList<Arquivo> lerPasta = new ArrayList<Arquivo>();
	
	public ArrayList<File> listFiles (File directory) {
        ArrayList<File> files = new ArrayList<File>();
        listFiles (files, directory);
        return files;
    }
    
	
	private void listFiles (List<File> files, File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                listFiles (files, file);
            } else {
                files.add (file);
            }
        }
    }
	
	
	public void adicionarArquivo(Object file){
		
	}
}

