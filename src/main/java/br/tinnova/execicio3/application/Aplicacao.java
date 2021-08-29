package br.tinnova.execicio3.application;

import java.math.BigDecimal;
import java.util.Scanner;

import br.tinnova.execicio3.view.ViewExercicio3;
import br.tinnova.execicio3.application.utils.AlgoritmosCalculo;
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
		ViewExercicio3 view = new ViewExercicio3(scanner);
		do {
			int value = view.getValue();
			BigDecimal result = AlgoritmosCalculo.factorial(value);
			view.showValue(result);
		}while(view.sair());
	}
}
