package br.tinnova.execicio5.api.controllers;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.tinnova.execicio5.application.entities.Veiculo;
import br.tinnova.execicio5.application.gateway.VeiculoGateway;

@RestController
@CrossOrigin
@RequestMapping(value = "/veiculos")
public class VeiculoController {
	
	@Autowired
	VeiculoGateway veiculoGateway;
	
	@GetMapping("/example")
	public ResponseEntity<Veiculo> getVeiculo() {
		Veiculo v= new Veiculo();
		v.setAno(2020);
		v.setCreated(ZonedDateTime.now());
		v.setUpdated(ZonedDateTime.now());
		v.setMarca("Volkswagen");
		v.setVendido(false);
		v.setVeiculo("Nivus");
		v.setDescricao("Descricao");
		return ResponseEntity.status(HttpStatus.OK).body(v);
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> getVeiculos(@RequestParam(name = "q", required = false) String find) {
		if(find == null) return ResponseEntity.status(HttpStatus.OK).body(veiculoGateway.list());
		System.out.println(find);
		
		return ResponseEntity.status(HttpStatus.OK).body(veiculoGateway.listByContent(find));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> getVeiculos(@PathVariable("id") UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(veiculoGateway.listById(id));
	}

	@PostMapping("")
	public ResponseEntity<Veiculo> postVeiculo(@RequestBody Veiculo veiculo) {
		Veiculo veiculoCriado = veiculoGateway.create(veiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCriado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> putVeiculo(@PathVariable("id") UUID id, @RequestBody Veiculo veiculo) {
		Veiculo veiculoCriado = veiculoGateway.save(id, veiculo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(veiculoCriado);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Veiculo> patchVeiculo(@PathVariable("id") UUID id, @RequestBody Veiculo veiculo) {
		Veiculo veiculoCriado = veiculoGateway.update(id, veiculo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(veiculoCriado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Veiculo> deleteVeiculo(@PathVariable("id") UUID id) {
		veiculoGateway.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
