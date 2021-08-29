package br.tinnova.execicio5.infrastructure.providers.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import br.tinnova.execicio5.application.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
	List<Veiculo> findByVeiculoIgnoreCaseContainingOrMarcaIgnoreCaseContainingOrDescricaoIgnoreCaseContaining(String veiculo, String marca, String descricao);
}
