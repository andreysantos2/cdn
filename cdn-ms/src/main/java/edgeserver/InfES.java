package edgeserver;

import originserver.Arquivo;

public class InfES {
	private String server;
	private String status;
	private Arquivo arquivo;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Arquivo getArquivo() {
		return arquivo;
	}
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
	
}
