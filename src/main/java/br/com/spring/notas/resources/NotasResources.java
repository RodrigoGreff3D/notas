package br.com.spring.notas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.notas.model.Notas;
import br.com.spring.notas.repository.NotasRepository;

@RestController
@RequestMapping(value = "/postit")
public class NotasResources {

	@Autowired
	NotasRepository notasRepository;

	@GetMapping(value = "notas")
	public List<Notas> listaNotas() {
		return notasRepository.findAll();
	}

	@GetMapping(value = "nota/{id}")
	public Notas notas(@PathVariable(value = "id") long id) {
		return notasRepository.findById(id);
	}
	
	@PostMapping("/nota")
	public Notas salvar(@RequestBody Notas nota) {
		return notasRepository.save(nota);
	}
	
	@DeleteMapping("/nota")
	public void delete(@RequestBody Notas nota) {
		notasRepository.delete(nota);
	}

}
