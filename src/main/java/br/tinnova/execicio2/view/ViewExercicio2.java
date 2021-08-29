package br.tinnova.execicio2.view;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Emerick
 * 
 * Classe que representa a tela de exibição para o usuário.
 *
 */
public class ViewExercicio2 {
	
	private Scanner scanner;
	
	public ViewExercicio2 (Scanner scanner) {
		this.scanner = scanner;
	}
	
	/**
	 * 
	 * Solicita ao usuário a quantidade de números a serem ordenados.
	 * 
	 * @return - quantidade números a serem ordenados
	 */
	public int getQuantity() {
		int op;
		do {
			System.out.println("****************************");
			System.out.print("Informe quantos números serão ordenados (maior que 0):");
			try {
				op = scanner.nextInt();
				if(op <= 0) {
					System.err.println("Informe um valor válido.");
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor válido.");
				scanner.next();
				op = -1;
			}
			System.out.println();
		}while(op <= 0);
		return op;
	}
	
	/**
	 * 
	 * Solicita ao usuário os números a serem ordenados.
	 * 
	 * @param quantity - quantidade de números a serem ordenados.
	 * @return - array contendo os números informados pelo usuário na ordem de inserção.
	 */
	public int[] getArray(int quantity) {
		
		int[] inteiros = new int[quantity];
		
		System.out.println("****************************");
		System.out.println("Agora me informe os números que serão ordenados");
		int i = 0;
		do {
			System.out.println("****************************");
			System.out.print("Informe um número (resta(m) "+(quantity-i)+" números): ");
			try {
				inteiros[i] = scanner.nextInt();
				i++;
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor válido.");
				scanner.next();
				
			}
			System.out.println();
		}while(i < quantity);
		return inteiros;
	}
	
	/**
	 * 
	 * Exibe um array de números inteiros.
	 * 
	 * @param array - array de números inteiros.
	 */
	public void showArray(int[] array) {
		System.out.println("****************************");
		for(int value : array) {
			System.out.println(value);
		}
	}
	
	/**
	 * Pergunta ao usuário se deseja sair ou não, retornando um boolean.
	 * 
	 * @return - retorna true se deseja sair ou false se deseja continuar.
	 */
	public boolean sair() {
		int op;
		do {
			System.out.println("****************************");
			System.out.print("Você quer sair? (0 - não, 1 - sim)");
			try {
				op = scanner.nextInt();
				if(op < 0 || op > 1) {
					System.err.println("Informe um valor válido.");
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor válido.");
				scanner.next();
				op = -1;
			}
			System.out.println();
		}while(op < 0 || op > 1);
		return op != 1;
	}
	
}
