package Ej11;

import java.util.Scanner;

public class Ej11App {

	public static void main(String[] args) {

		// Declaración de variables
		int[] arrayUno;
		int[] arrayDos;
		int[] arrayTres;
		int cantidadNum = 0;

		// Pedir la cantidad de numeros aleatorios a generar y instanciar un array con
		// las posiciones introducidas
		cantidadNum = pedirParametro("Cuantos numeros aleatorios quieres generar: ");
		arrayUno = new int[cantidadNum];
		
		//Llenar el primer array con numeros aleatorios entre 1 y 10
		rellenarConRandoms(arrayUno, 1, 10);
		
		//Apuntar el segundo array al primero
		arrayDos = arrayUno;
		
		//"Rellenar el segundo array" con valores aleatorios entre 20 y 40
		rellenarConRandoms(arrayDos, 20, 40);
		
		/*Multiplicar cada posición del array1 con la misma posicion del array2 y guardar 
		 *el resultado en la misma posicion un nuevo array devuelto por el metodo y acumularlo en array3
		 */
		arrayTres = multiplicarArrays(arrayUno, arrayDos);
		
		/*El segundo array al apuntar al primero lo único que hace es ser un puntero al mismo array que array1
		 * con lo que son el mismo array y al modificar arrayDos se está modificando el espacio de memoria al cual
		 * apuntan tanto arrayUno como arrayDos*/
		System.out.println("Valores del array 1");
		mostrarNumeros(arrayUno);
		System.out.println("Valores del array 2");
		mostrarNumeros(arrayDos);
		System.out.println("Valores del array 3");
		mostrarNumeros(arrayTres);
	}
	
	public static void rellenarConRandoms(int[] numeros, int min, int max) {
		for(int i = 0; i < numeros.length; i++) {
			//Generar el numero aleatorio masandole los valores al metodo y acumulandolo en su posicion del array
			numeros[i] = (int) Math.round(Math.random() * (max-min) + min);
		}
	}
	
	public static void mostrarNumeros(int[] numeros) {
		for(int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();
	}
	
	/*Metodo que recorre los dos arrays pasados por parametro multiplicando cada posicion
	 *y guardando el resultado en un nuevo array que es devuelto
	 */
	public static int[] multiplicarArrays(int[] arr1, int[] arr2) {
		
		int[] resultado = new int[arr1.length];
		
		for(int i = 0; i < resultado.length; i++) {
			resultado[i] = arr1[i] * arr2[i];
		}
		
		return resultado;
	}

	// Metodo para pedir un valor válido parta los parametros
	public static int pedirParametro(String mensaje) {

		// Declaracíon de variables locales del metodo
		Scanner teclado = new Scanner(System.in);
		String valorIntroducido = "";
		boolean valorValido = false;
		int param = 0;

		do {
			System.out.print(mensaje);
			valorIntroducido = teclado.nextLine();

			try {
				param = Integer.parseInt(valorIntroducido);

				if (param > 0) {
					valorValido = true;
				} else {
					System.out.println("Valor no válido, tiene que ser positivo (mayor que 0) \n\n");
				}
			} catch (Exception e) {
				System.out.println("Valor no válido \n\n");
			}

		} while (!valorValido);

		teclado.close();

		return param;
	}

}
