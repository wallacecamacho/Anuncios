package br.com.anuncios.model.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmailVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 891016095664511843L;

	private String nome;
	private String emailCco;
	private String mensagem;
	
	
	@NotEmpty
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty
	@Email
	public String getEmailCco() {
		return emailCco;
	}
	public void setEmailCco(String emailCco) {
		this.emailCco = emailCco;
	}
	
	@NotEmpty
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
