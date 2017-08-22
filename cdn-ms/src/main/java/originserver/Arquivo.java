package originserver;
import java.util.*;
public class Arquivo {

private String host;
private String nome;
private int id;
private String extensao;
private long enviada = 0;
private long tamanhoByte;


public String getHost() {
	return host;
}
public void setHost(String host) {
	this.host = host;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public long getEnviada() {
	return enviada;
}
public void setEnviada(long enviada) {
	this.enviada = enviada;
}
public long getTamanhoByte() {
	return tamanhoByte;
}
public void setTamanhoByte(long tamanhoByte) {
	this.tamanhoByte = tamanhoByte;
}

public String getExtensao() {
	return extensao;
}
public void setExtensao(String extensao) {
	this.extensao = extensao;
}

}
