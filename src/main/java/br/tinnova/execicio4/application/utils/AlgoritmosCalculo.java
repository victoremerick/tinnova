package br.tinnova.execicio4.application.utils;

import java.math.BigInteger;

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
	public static BigInteger somaMultiplos3ou5(BigInteger value) {
		BigInteger soma = new BigInteger("0");
		BigInteger num1 = new BigInteger("1");
		BigInteger num0 = new BigInteger("0");
		BigInteger num3 = new BigInteger("3");
		BigInteger num5 = new BigInteger("5");
		for(BigInteger i = new BigInteger("1"); i.compareTo(value)==-1; i = i.add(num1)) {
			if(i.remainder(num3).compareTo(num0)==0 || i.remainder(num5).compareTo(num0)==0) {
				soma = soma.add(i);
			}
		}
		return soma;
	}
	
}
