package br.com.ifms.lp2.javabeans;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEndereco;
	private String nomeRua;
	
	
	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
	
}
