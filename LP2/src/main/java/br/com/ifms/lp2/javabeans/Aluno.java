package br.com.ifms.lp2.javabeans;

 
 

 

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;




@Entity
public class Aluno {
	@ApiModelProperty(value = "Código do Aluno")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank(message =" O campo nome não pode ser branco")
	private long idAluno;
	@NotBlank(message =" O campo cpf não pode ser branco")
	private String nome;
	@ApiModelProperty(value = "cpf do Aluno")
	private String cpf;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}
	
	@OneToOne
	private Endereco endereco;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Enumerated
	private EstadoCivil estadocivil;
	
}
