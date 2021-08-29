package br.tinnova.execicio2.application;

import java.util.Scanner;

import br.tinnova.execicio2.application.utils.AlgoritmosOrdenacao;
import br.tinnova.execicio2.view.ViewExercicio2;
/**
 * @author Emerick
 *
 * A classe Aplicacao é a camada de aplicação do sistema, onde tem-se o controle geral
 * da aplicação.
 *
 */
public class Aplicacao {
	private final static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Inicia a aplicação.
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
