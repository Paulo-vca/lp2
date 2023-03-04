package br.com.ifms.lp2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ifms.lp2.javabeans.Endereco;
import br.com.ifms.lp2.repository.EnderecoRepository;

public class EnderecoResource {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@PostMapping("/inserir")
	public Endereco salvarEndereco(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
}
