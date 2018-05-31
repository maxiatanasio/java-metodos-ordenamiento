package util_ordenamiento;

public class Prueba {

	public static void main(String[] args) {
		
		int [] numeros = {5,7,3,19,67,8,4,1,9,-2,6,99};
		
		mostrarArray(numeros);
		
		//MetodosOrdenamiento.quickSort(numeros, 0, numeros.length - 1);
		//MetodosOrdenamiento.seleccion(numeros);
		//MetodosOrdenamiento.insercion(numeros);
		//MetodosOrdenamiento.shell(numeros, 4);
		//MetodosOrdenamiento.burbuja(numeros);
		MetodosOrdenamiento.mergeSort(numeros, 0, numeros.length - 1);
		
		mostrarArray(numeros);

	}
	
	public static void mostrarArray(int [] num) {
		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
