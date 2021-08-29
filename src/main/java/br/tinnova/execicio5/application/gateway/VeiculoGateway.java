package br.tinnova.execicio5.application.gateway;

import java.util.List;
import java.util.UUID;

import br.tinnova.execicio5.application.entities.Veiculo;

public interface VeiculoGateway {
	List<Veiculo> list();
	List<Veiculo> listByContent(String q);
	Veiculo listById(UUID id);
	
	Veiculo create(Veiculo veiculo);
	Veiculo save(UUID id, Veiculo veiculo);
	Veiculo update(UUID id, Veiculo veiculo);
	void delete(UUID id);
}
