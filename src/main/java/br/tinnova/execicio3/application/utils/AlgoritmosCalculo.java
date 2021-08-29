package br.tinnova.execicio3.application.utils;

import java.math.BigDecimal;

/**
 * @author Consultor.Externo
 *
 *	Classe reservada para inserir metodos de calculos numéricos.
 *
 */
public class AlgoritmosCalculo {
	
	private AlgoritmosCalculo() {};
	
	/**
	 * Executa o calculo de fatorial a partir do valor informado.
	 * 
	 * @param i - número a ser calculado o fatorial.
	 * @return - resultado do fatorial.
	 */
	public static BigDecimal factorial(int i) {
		BigDecimal result = new BigDecimal(1);
		while(i > 0) result = result.multiply(new BigDecimal(i--));
		return result;
	}
	
}
