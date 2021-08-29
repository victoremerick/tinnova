package br.tinnova.execicio1.eleicoes.models;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Emerick
 * 
 * Classe que representa uma eleição.
 *
 */
@Getter
@Setter
public class Eleicao {
	private BigDecimal votosValidos;
	private BigDecimal votosNulos;
	private BigDecimal votosBrancos;
	
	public Eleicao() {
		votosValidos = new BigDecimal(0);
		votosValidos.setScale(2);
		votosNulos = new BigDecimal(0);
		votosNulos.setScale(2);
		votosBrancos = new BigDecimal(0);
		votosBrancos.setScale(2);
	}
	
	public BigDecimal getTotalVotos() {
		return votosValidos.add(votosBrancos).add(votosNulos);
	}
}
