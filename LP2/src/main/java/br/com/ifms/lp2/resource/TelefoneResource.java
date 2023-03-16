package br.com.ifms.lp2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.lp2.javabeans.Telefone;
import br.com.ifms.lp2.repository.TelefoneRepository;

@RestController
@RequestMapping(value = "/api/telefone")
public class TelefoneResource {
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	
	
	
	@PostMapping("/inserir")
	public Telefone salvarTelefone(@RequestBody Telefone telefone) {
		return telefoneRepository.save(telefone);
	}
	
}
