package br.tinnova.execicio1.eleicoes.view;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Emerick
 * 
 * Classe que representa a tela de exibi��o para o usu�rio.
 *
 */
public class ViewEleicao {
	
	private Scanner scanner;
	
	/**
	 * 
	 * Inicia a comunica��o com o usu�rio atrav�s do console.
	 * 
	 * @param scanner - Inst�ncia da classe Scanner para solicitar inputs do usu�rio.
	 */
	public ViewEleicao (Scanner scanner) {
		this.scanner = scanner;
	}
	
	/**
	 * Mostra um menu com op��es para iniciar uma elei��o ou sair do programa.
	 * 
	 * @return Retorna 1 para iniciar uma elei�ao ou 2 para sair da aplica��o
	 */
	public int getOptionMenuInicial() {
		int op;
		do {
			System.out.println("****************************");
			System.out.println("MENU");
			System.out.println("****************************");
			System.out.println("1 - Iniciar Eleicao");
			System.out.println("2 - Sair");
			System.out.println("****************************");
			System.out.print("Escolha uma op��o: ");
			try {
				op = scanner.nextInt();
				if(op <= 0 || op >= 3) {
					System.err.println("Informe um valor v�lido.");
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor v�lido.");
				scanner.next();
				op = -1;
			}
			System.out.println();
		}while(op != 1 && op != 2);
		return op;
	}
	

	
	/**
	 * 
	 * Exibe um menu com op��es para o usuario executar em uma elei��o e aguarda a escolha
	 * da funcionalidade que deseja executar.
	 * 
	 * @return retorna um inteiro com op��es de 0 a 7, sendo 0 finalizar a elei��o e voltar
	 * ao menu anterior
	 */
	public int getOptionMenuEleicao() {
		int op;
		do {
			System.out.println("****************************");
			System.out.println("ELEI��O");
			System.out.println("****************************");
			System.out.println("1 - Add Votos Validos");
			System.out.println("2 - Add Votos Nulos");
			System.out.println("3 - Add Votos Brancos");
			System.out.println("4 - Ver Total");
			System.out.println("5 - Ver Percentual de Votos Validos");
			System.out.println("6 - Ver Percentual de Votos Nulos");
			System.out.println("7 - Ver Percentual de Votos Brancos");
			System.out.println("0 - Voltar");
			System.out.println("****************************");
			System.out.print("Escolha uma op��o: ");
			try {
				op = scanner.nextInt();
				if(op < 0 || op > 7) {
					System.err.println("Informe um valor v�lido.");
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor v�lido.");
				scanner.next();
				op = -1;
			}
		}while(op < 0 || op > 7);
		return op;
	}
	
	/**
	 * Solicitar ao usu�rio um n�mero positivo n�o-nulo.
	 * 
	 * @return Retorna um n�mero positivo n�o-nulo (return > 0)
	 */
	public BigInteger getValueEqualOrMoreThanZero() {
		
		BigInteger value = new BigInteger("0");
		boolean inRange = false;
		do {
			System.out.println("****************************");
			System.out.print("Informe o valor (maior que 0): ");
			try {
				value = scanner.nextBigInteger();
				boolean gt = value.compareTo(new BigInteger("0")) == 1;
				boolean eq = value.compareTo(new BigInteger("0")) == 0;
				inRange = gt || eq;
				if(!inRange) {
					System.err.println("Informe um valor v�lido.");
					inRange = false;
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Informe um valor v�lido.");
				scanner.next();
				inRange = false;
			}
		}while(!inRange);
		return value;
	}
	
	/**
	 * Exibe um valor qualquer.
	 * 
	 * @param Um texto para ser exibido.
	 */
	public void showValue(String value) {
		System.out.println("****************************");
		System.out.println(value);
	}
	
}
