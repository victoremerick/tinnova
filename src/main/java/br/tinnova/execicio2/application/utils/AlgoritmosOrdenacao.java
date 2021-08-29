package br.tinnova.execicio2.application.utils;

/**
 * @author Consultor.Externo
 *
 *	Classe reservada para inserir metodos de ordenação de arrays.
 *
 */
public class AlgoritmosOrdenacao {
	
	private AlgoritmosOrdenacao(){}
	
	/**
	 * 
	 * Ordenação de array numérico através do algoritmo bubblesort.
	 * 
	 * @param arr - array contendo números inteiros.
	 */
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}
	}
	
}
