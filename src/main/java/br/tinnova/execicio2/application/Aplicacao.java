package br.tinnova.execicio2.application;

import java.util.Scanner;

import br.tinnova.execicio2.application.utils.AlgoritmosOrdenacao;
import br.tinnova.execicio2.view.ViewExercicio2;
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
		ViewExercicio2 view = new ViewExercicio2(scanner);
		do {
			int quantity = view.getQuantity();
			int[] array = view.getArray(quantity);
			AlgoritmosOrdenacao.bubbleSort(array);
			view.showArray(array);
		}while(view.sair());
	}
}
