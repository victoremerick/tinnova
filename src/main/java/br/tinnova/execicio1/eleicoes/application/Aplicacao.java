package br.tinnova.execicio1.eleicoes.application;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import br.tinnova.execicio1.eleicoes.controller.ControllerEleicao;
import br.tinnova.execicio1.eleicoes.view.ViewEleicao;

/**
 * @author Emerick
 *
 * A classe Aplicacao é a camada de aplicação do sistema, onde tem-se o controle geral
 * da aplicação.
 *
 */
public class Aplicacao {
	
	private final static Scanner scanner = new Scanner(System.in);
	private static ViewEleicao view;
	
	private Aplicacao() {
	}
	
	/**
	 * Inicia a aplicação exibindo o menu inicial presente na classe ViewEleicao e solicitando
	 * ao usuário opções de como prosseguir na execução do programa.
	 */
	public static void start() {
		view = new ViewEleicao(scanner);
		int op = 0;
		do {
			op = view.getOptionMenuInicial();
			if(op == 1) {
				startEleicao();
			}
		}while(op != 2);
	}
	
	/**
	 * Representa o inicio da eleição, realizando a comunicação entre a camada de controle 
	 * (ControllerEleicao.java) e a camada de visualização (ViewEleicao.java). O controle é
	 * feito a partir de opções informadas pelo usuário na camada de visualização.
	 */
	private static void startEleicao() {
		ControllerEleicao controller = new ControllerEleicao();
		int op = 0;
		BigInteger value; 
		BigDecimal percentual, multiplicand100 = new BigDecimal(100);
		do {
			op = view.getOptionMenuEleicao();
			switch(op) {
				case 1:
					value = view.getValueEqualOrMoreThanZero();
					controller.addVotosValidos(new BigDecimal(value));
					break;
				case 2:
					value = view.getValueEqualOrMoreThanZero();
					controller.addVotosNulos(new BigDecimal(value));
					break;
				case 3:
					value = view.getValueEqualOrMoreThanZero();
					controller.addVotosBrancos(new BigDecimal(value));
					break;
				case 4:
					value = controller.getTotalVotos().toBigInteger();
					view.showValue(value + " votos");
					break;
				case 5:
					percentual = controller.getPercentualVotosValidos();
					view.showValue(percentual.multiply(multiplicand100) + "% de votos Validos");
					break;
				case 6:
					percentual = controller.getPercentualVotosNulos();
					view.showValue(percentual.multiply(multiplicand100) + "% de votos Validos");
					break;
				case 7:
					percentual = controller.getPercentualVotosBrancos();
					view.showValue(percentual.multiply(multiplicand100) + "% de votos Validos");
					break;
					
			}
		}while(op != 0);		
	}
}
