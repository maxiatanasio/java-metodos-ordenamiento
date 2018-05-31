package util_ordenamiento;

public class MetodosOrdenamiento {

	public static void burbuja(int [] numeros) {
	
		boolean huboCambio = true;
		int ultimaPosicion = numeros.length;
		while(huboCambio) {
			ultimaPosicion--;
			huboCambio = false;
			for(int i = 0; i < ultimaPosicion; i++) {
				if(numeros[i] > numeros[i+1]) {
					int aux = numeros[i];
					numeros[i] = numeros[i+1];
					numeros[i+1] = aux;
					huboCambio = true;
				}
			}
		}
		
	}
	
	public static void seleccion(int [] numeros) {
		for(int i = 0; i < numeros.length - 1;i++) {
			int minimo = numeros[i];
			int minPos = i;
			for(int k = i+1; k < numeros.length; k++) {
				if(numeros[k] < minimo) {
					minimo = numeros[k];
					minPos = k;
				}
			}
			int aux = numeros[i];
			numeros[i] = numeros[minPos];
			numeros[minPos] = aux;
		}
	}
	
	public static void insercion(int [] numeros) {
		int ultimaPosicionOrdenada = 0;
		for(int i = ultimaPosicionOrdenada + 1; i < numeros.length; i++) {
			int valor = numeros[i];
			int posicionInsercion = ultimaPosicionOrdenada;
			for(int j = ultimaPosicionOrdenada; j >= 0; j--) {
				if(valor < numeros[j]) {
					numeros[j+1] = numeros[j];
					posicionInsercion--;
				} else {
					break;
				}
			}
			numeros[posicionInsercion+1] = valor;
			ultimaPosicionOrdenada++;
		}
	}
	
	public static void quickSort(int [] numeros, int primerIndice, int ultimoIndice) {
		
		int pivot = numeros[primerIndice];
		int posicionReemplazo = primerIndice + 1;
		for(int i = posicionReemplazo; i <= ultimoIndice; i++) {
			if(numeros[i] < pivot) {
				int aux = numeros[posicionReemplazo];
				numeros[posicionReemplazo] = numeros[i];
				numeros[i] = aux;
				posicionReemplazo++;
			}
		}
		
		numeros[primerIndice] = numeros[posicionReemplazo-1];
		numeros[posicionReemplazo-1] = pivot;
		
		int primerIndiceIzquierda = primerIndice == posicionReemplazo ? primerIndice + 1 : primerIndice;
		int ultimoIndiceIzquierda = posicionReemplazo - 2;
		int primerIndiceDerecha = posicionReemplazo;
		int ultimoIndiceDerecha = ultimoIndice == posicionReemplazo ? ultimoIndice - 1 : ultimoIndice;
		
		if(ultimoIndiceIzquierda - primerIndiceIzquierda > 1) {
			quickSort(numeros, primerIndiceIzquierda, ultimoIndiceIzquierda);
		}
		if(ultimoIndiceDerecha - primerIndiceDerecha > 1) {
			quickSort(numeros, primerIndiceDerecha, ultimoIndiceDerecha);
		}
		
	}
	
	public static void shell(int [] numeros, int pasos) {
		if(pasos == 0) return;
		int ultimaPosicionOrdenada = 0;
		for(int i = ultimaPosicionOrdenada + pasos; i < numeros.length; i += pasos) {
			int valor = numeros[i];
			int posicionInsercion = ultimaPosicionOrdenada;
			for(int j = ultimaPosicionOrdenada; j >= 0; j-=pasos) {
				if(valor < numeros[j]) {
					numeros[j+pasos] = numeros[j];
					posicionInsercion-=pasos;
				} else {
					break;
				}
			}
			numeros[posicionInsercion+pasos] = valor;
			ultimaPosicionOrdenada+= pasos;
		}
		shell(numeros,pasos-1);
	}
	
	public static void mergeSort(int [] numeros, int inicio, int fin) {
		int longitud = fin - inicio;
		if(longitud < 1) return;
		int indiceMedio = (fin + inicio) / 2;
		
		mergeSort(numeros, inicio, indiceMedio);
		mergeSort(numeros, indiceMedio+1, fin);
		
		merge(numeros, inicio, indiceMedio, fin);
		
	}
	
	public static void merge(int [] numeros, int inicio, int mitad, int fin) {
		int [] nInicial, nFinal;
		nInicial = new int [mitad-inicio+1];
		nFinal = new int [fin-mitad];
		
		for(int i = inicio; i <= mitad; i++) {
			nInicial[i-inicio] = numeros[i];
		}
		
		for(int i = mitad+1; i <= fin; i++) {
			nFinal[i-(mitad+1)] = numeros[i];
		}
		
		int ultimoComparado = 0;
		int pos = inicio;
		for(int i = 0; i < nInicial.length; i++) {
			int valor = nInicial[i];
			for(int k = ultimoComparado; k < nFinal.length; k++) {
				if(nFinal[k] < valor) {
					numeros[pos] = nFinal[k];
					pos++;
					ultimoComparado++;
				} else {
					break;
				}
			}
			numeros[pos] = valor;
			pos++;
		}
	}
	
}
