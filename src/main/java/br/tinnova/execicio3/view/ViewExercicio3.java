package br.tinnova.execicio3.view;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Emerick
 * 
 * Classe que representa a tela de exibi��o para o usu�rio.
 *
 */
public class ViewExercicio3 {
	
	private Scanner scanner;
	
	public ViewExercicio3 (Scanner scanner) {
		this.scanner = scanner;
	}
	/**
	 * 
	 * Solicita ao usu�rio o n�mero a ser calculado o fatorial.
	 * 
	 * @return - numero para calcular o fatorial
	 */
	public int getValue() {
		int op;
		do {
			System.out.println("****************************");
			System.out.print("Informe um valor para calcular o fatorial (maior ou igual a 0):");
			try {
				op = scanner.nextInt();
				if(op < 0) {
					System.err.println("Informe um valor v�lido.");
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor v�lido.");
				scanner.next();
				op = -1;
			}
			System.out.println();
		}while(op < 0);
		return op;
	}
	
	/**
	 * 
	 * Exibe um valor de BigDecimal
	 * 
	 * @param value - valor a ser exibido.
	 */
	public void showValue(BigDecimal value) {
		System.out.println("****************************");
		System.out.println("Resultado: "+value);
	}
	
	/**
	 * 
	 * Question ao usuario se deseja sair.
	 * 
	 * @return - true se o usuario quer sair ou false se o usu�rio n�o quer.
	 */
	public boolean sair() {
		int op;
		do {
			System.out.println("****************************");
			System.out.print("Voc� quer sair? (0 - n�o, 1 - sim) ");
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
