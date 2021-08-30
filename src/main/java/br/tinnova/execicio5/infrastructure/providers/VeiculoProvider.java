package br.tinnova.execicio5.infrastructure.providers;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tinnova.execicio5.application.entities.Veiculo;
import br.tinnova.execicio5.application.gateway.VeiculoGateway;
import br.tinnova.execicio5.infrastructure.providers.repositories.VeiculoRepository;

@Service
public class VeiculoProvider implements VeiculoGateway {

	@Autowired
	private VeiculoRepository repository;
	
	@Override
	public List<Veiculo> list() {
		return repository.findAll();
	}

	@Override
	public List<Veiculo> listByContent(String q) {
		return repository.findByVeiculoIgnoreCaseContainingOrMarcaIgnoreCaseContainingOrDescricaoIgnoreCaseContaining(q, q, q);
	}

	@Override
	public Veiculo listById(UUID id) {
		return repository.findById(id).get();
	}

	@Override
	public Veiculo create(Veiculo veiculo) {
		return repository.save(veiculo);
	}

	@Override
	public Veiculo save(UUID id, Veiculo veiculo) {
		veiculo = mergeVeiculo(repository.findById(id).get(), veiculo);
		return repository.save(veiculo);
		
	}

	@Override
	public Veiculo update(UUID id, Veiculo veiculo) {
		veiculo = mergeVeiculo(repository.findById(id).get(), veiculo);
		veiculo.setUpdated(ZonedDateTime.now());
		return repository.save(veiculo);
		
	}

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
	}
	
	private Veiculo mergeVeiculo(Veiculo fromDatabase, Veiculo fromRequest) {
		fromDatabase.setAno(fromRequest.getAno() == null ? fromDatabase.getAno(): fromRequest.getAno());
		fromDatabase.setDescricao(fromRequest.getDescricao() == null ? fromDatabase.getDescricao(): fromRequest.getDescricao());
		fromDatabase.setMarca(fromRequest.getMarca() == null ? fromDatabase.getMarca(): fromRequest.getMarca());
		fromDatabase.setVeiculo(fromRequest.getVeiculo() == null ? fromDatabase.getVeiculo(): fromRequest.getVeiculo());
		fromDatabase.setAno(fromRequest.getAno() == null ? fromDatabase.getAno(): fromRequest.getAno());
		fromDatabase.setVendido(fromRequest.isVendido());
		return fromDatabase;
	}

}
