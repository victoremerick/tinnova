package br.tinnova.execicio2.view;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Emerick
 * 
 * Classe que representa a tela de exibi��o para o usu�rio.
 *
 */
public class ViewExercicio2 {
	
	private Scanner scanner;
	
	public ViewExercicio2 (Scanner scanner) {
		this.scanner = scanner;
	}
	
	/**
	 * 
	 * Solicita ao usu�rio a quantidade de n�meros a serem ordenados.
	 * 
	 * @return - quantidade n�meros a serem ordenados
	 */
	public int getQuantity() {
		int op;
		do {
			System.out.println("****************************");
			System.out.print("Informe quantos n�meros ser�o ordenados (maior que 0):");
			try {
				op = scanner.nextInt();
				if(op <= 0) {
					System.err.println("Informe um valor v�lido.");
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor v�lido.");
				scanner.next();
				op = -1;
			}
			System.out.println();
		}while(op <= 0);
		return op;
	}
	
	/**
	 * 
	 * Solicita ao usu�rio os n�meros a serem ordenados.
	 * 
	 * @param quantity - quantidade de n�meros a serem ordenados.
	 * @return - array contendo os n�meros informados pelo usu�rio na ordem de inser��o.
	 */
	public int[] getArray(int quantity) {
		
		int[] inteiros = new int[quantity];
		
		System.out.println("****************************");
		System.out.println("Agora me informe os n�meros que ser�o ordenados");
		int i = 0;
		do {
			System.out.println("****************************");
			System.out.print("Informe um n�mero (resta(m) "+(quantity-i)+" n�meros): ");
			try {
				inteiros[i] = scanner.nextInt();
				i++;
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor v�lido.");
				scanner.next();
				
			}
			System.out.println();
		}while(i < quantity);
		return inteiros;
	}
	
	/**
	 * 
	 * Exibe um array de n�meros inteiros.
	 * 
	 * @param array - array de n�meros inteiros.
	 */
	public void showArray(int[] array) {
		System.out.println("****************************");
		for(int value : array) {
			System.out.println(value);
		}
	}
	
	/**
	 * Pergunta ao usu�rio se deseja sair ou n�o, retornando um boolean.
	 * 
	 * @return - retorna true se deseja sair ou false se deseja continuar.
	 */
	public boolean sair() {
		int op;
		do {
			System.out.println("****************************");
			System.out.print("Voc� quer sair? (0 - n�o, 1 - sim)");
			try {
				op = scanner.nextInt();
				if(op < 0 || op > 1) {
					System.err.println("Informe um valor v�lido.");
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor v�lido.");
				scanner.next();
				op = -1;
			}
			System.out.println();
		}while(op < 0 || op > 1);
		return op != 1;
	}
	
}
