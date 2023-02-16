package br.com.ifms.lp2.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/aluno")

public class AlunoResource {
	@GetMapping("/aluno/{nome}")
	public String getMeuNome(@PathVariable String nome) {
		return "Meu nome é: " + nome;
	}
}
