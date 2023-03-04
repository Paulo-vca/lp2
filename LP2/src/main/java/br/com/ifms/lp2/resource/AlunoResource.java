package br.com.ifms.lp2.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.lp2.javabeans.Aluno;
import br.com.ifms.lp2.repository.AlunoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/aluno")

public class AlunoResource {
	@Autowired
	AlunoRepository alunoRepository;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = " Nome adicionado com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
	})
	@GetMapping("/MeuNome/{nome}")
	public String getMeuNome(@PathVariable String nome) {
		return "Meu nome é: " + nome;
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = " Nome e Sobreno adicionado com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
	})
	@GetMapping("/MeuNomeSobrenome")
	public String getNomeSobreNome(@RequestParam String nome, @RequestParam String sobreNome) {
		return "Meu nome completo é: " +nome + " " +sobreNome;
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = " Inserido aluno com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
	})
	@PostMapping("/inserir")
	public Aluno salvarAluno(@RequestBody @Valid Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = " Listado com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
	})
	//http://localhost:8080/api/aluno/listarAlunos
	@GetMapping("/listarAlunos")
	public List<Aluno> listarAluno(){
		return alunoRepository.findAll();
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = " ID do aluno encontrado com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
	})
	//http://localhost:8080/api/aluno/alunoid/2
		@GetMapping("/alunoid/{id}")
		public Optional<Aluno> buscaAluno(@PathVariable(value="id")long id){
			return alunoRepository.findById(id);
		}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = " ID do aluno removido com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
	})
	//http://localhost:8080/api/aluno/remover/2
	@DeleteMapping(value="/remover/{id}")
	public void deleteAluno(@PathVariable("id")long id) throws Exception {
		
		Optional<Aluno> aluno = alunoRepository.findById(id);
		if (aluno.get().getIdAluno() > 0) {
			alunoRepository.deleteById(id);
		} else {
			System.out.println("não encontrado");
			throw new Exception("ID não encontrado!!!");
		}
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = " ID do aluno atulizado com sucesso!!!"),
			@ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerado uma exceção")
	})
	//http://localhost:8080/api/aluno/atualizar/2
	@PutMapping("/atualizar/{id}")
	public void atualizarAluno(@PathVariable(value= "id")long id,@RequestBody Aluno novoAluno) {
		Optional<Aluno> antigoAluno = alunoRepository.findById(id);
		
		if(antigoAluno.get().getIdAluno() > 0) {
			novoAluno.setIdAluno(antigoAluno.get().getIdAluno());
			alunoRepository.save(novoAluno);
		}
	}
		
	
}



