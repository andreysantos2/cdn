package OrigemServer;
import java.util.*;
public class Arquivo {

private String nome;
private String extensao;
private long enviada = -1;
private long tamanhoByte;


public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getExtensao() {
	return extensao;
}
public void setExtensao(String extensao) {
	this.extensao = extensao;
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

}
