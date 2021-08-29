package br.tinnova.execicio1.eleicoes.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.tinnova.execicio1.eleicoes.models.Eleicao;

/**
 * @author Emerick
 *
 * Classe que representa a camada de controle executando tarefas de acordo com o que
 * receber da camada de aplicação.
 * 
 */
public class ControllerEleicao {
	Eleicao eleicao;
	
	/**
	 * Inicia uma nova eleicao.
	 */
	public ControllerEleicao(){
		this.eleicao = new Eleicao();
	}
	
	/**
	 * Aumenta a quantidade de votos validos a partir do parametro.
	 * 
	 * @param Votos validos a serem somados aos já inseridos.
	 */
	public void addVotosValidos(BigDecimal votos) {
		this.eleicao.setVotosValidos(this.eleicao.getVotosValidos().add(votos));
	}
	
	/**
	 * Aumenta a quantidade de votos nulos a partir do parametro.
	 * 
	 * @param Votos nulos a serem somados aos já inseridos.
	 */
	public void addVotosNulos(BigDecimal votos) {
		this.eleicao.setVotosNulos(this.eleicao.getVotosNulos().add(votos));
	}
	
	/**
	 * Aumenta a quantidade de votos brancos a partir do parametro.
	 * 
	 * @param Votos brancos a serem somados aos já inseridos.
	 */
	public void addVotosBrancos(BigDecimal votos) {
		this.eleicao.setVotosBrancos(this.eleicao.getVotosBrancos().add(votos));
	}
	
	/**
	 * Retorna o total de votos validos.
	 * 
	 * @return Retorna o total de votos validos.
	 */
	public BigDecimal getVotosValidos() {
		return this.eleicao.getVotosValidos();
	}
	
	/**
	 * Retorna o total de votos nulos.
	 * 
	 * @return Retorna o total de votos nulos.
	 */
	public BigDecimal getVotosNulos() {
		return this.eleicao.getVotosNulos();
	}
	
	/**
	 * Retorna o total de votos brancos.
	 * 
	 * @return Retorna o total de votos brancos.
	 */
	public BigDecimal getVotosBrancos() {
		return this.eleicao.getVotosBrancos();
	}
	
	/**
	 * 
	 * Retorna a soma total de votos.
	 * 
	 * @return Retorna a soma total de votos (brancos + nulos + validos)
	 */
	public BigDecimal getTotalVotos() {
		return this.eleicao.getTotalVotos();
	}
	
	/**
	 * 
	 * Retorna o percentual entre votos validos e totais. (validos/totais)
	 * 
	 * @return Cálculo de VotosValidos/TotalDeVotos com precisão de 2 casas decimais.
	 */
	public BigDecimal getPercentualVotosValidos() {
		return getVotosValidos().divide(getTotalVotos(), 2, RoundingMode.HALF_EVEN);
	}
	
	/**
	 * 
	 * Retorna o percentual entre votos nulos e totais. (nulos/totais)
	 * 
	 * @return Cálculo de VotosNulos/TotalDeVotos com precisão de 2 casas decimais.
	 */
	public BigDecimal getPercentualVotosNulos() {
		return getVotosNulos().divide(getTotalVotos(), 2, RoundingMode.HALF_EVEN);
	}
	
	/**
	 * 
	 * Retorna o percentual entre votos brancos e totais. (brancos/totais)
	 * 
	 * @return Cálculo de VotosBrancos/TotalDeVotos com precisão de 2 casas decimais.
	 */
	public BigDecimal getPercentualVotosBrancos() {
		return getVotosBrancos().divide(getTotalVotos(), 2, RoundingMode.HALF_EVEN);
	}
}
