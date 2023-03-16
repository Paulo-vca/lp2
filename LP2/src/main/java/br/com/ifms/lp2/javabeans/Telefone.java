package br.com.ifms.lp2.javabeans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTelefone;
	private String numero;
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(long idTelefone) {
		this.idTelefone= idTelefone;
	}
}
