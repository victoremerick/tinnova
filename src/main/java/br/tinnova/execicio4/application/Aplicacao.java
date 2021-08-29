package br.tinnova.execicio4.application;

import java.math.BigInteger;
import java.util.Scanner;

import br.tinnova.execicio4.view.ViewExercicio4;
import br.tinnova.execicio4.application.utils.AlgoritmosCalculo;
/**
 * @author Emerick
 *
 * A classe Aplicacao � a camada de aplica��o do sistema, onde tem-se o controle geral
 * da aplica��o.
 *
 */
public class Aplicacao {
	private final static Scanner scanner = new Scanner(System.in);
	/**
	 * Inicia a aplica��o.
	 */
	public static void start() {
		ViewExercicio4 view = new ViewExercicio4(scanner);
		do {
			BigInteger value = view.getValue();
			BigInteger result = AlgoritmosCalculo.somaMultiplos3ou5(value);
			view.showValue(result);
		}while(view.sair());
	}
}
