import java.util.Arrays;
import java.util.Random;

class Alumno{
	private String nombre;
	private String carrera;
	private int promedio;
	
	public Alumno(String nombre, String carrera, int promedio) {
		super();
		this.nombre = nombre;
		this.carrera = carrera;
		this.promedio = promedio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getPromedio() {
		return promedio;
	}
	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "Alumno [ nombre: " + nombre + ", carrera: " + carrera + ", promedio: " + promedio + " ]";
	}
}

class OrdenamientoBurbuja{
	
	public static void burbuja1(int[] datos) {
		
		long tFin, tInicio = System.currentTimeMillis();
		int intercambios = 0, comparaciones = 0, recorrido = 0;
		for (int i = 1; i < datos.length; i++) {
			for (int j = 0; j < datos.length -i - 1; j++) {
				comparaciones++;
				if(datos[j] > datos[j+1]) {
					intercambios++;
					int aux = datos[j];
					datos[j] = datos[j+1];
					datos[j+1] = aux;
				}
				recorrido++;
			}
		}
		
		tFin = System.currentTimeMillis();
		System.out.println("Tiempo de ordenamiento Burbuja 1: " + (tFin -tInicio));
	}
	
	public static void ordenacionBurbuja2(long []numeros) {
    	long tInicio = System.nanoTime();
        for(int i=1; i<numeros.length; i++) {
			
			for(int j=0; j<numeros.length-i; j++) {
				
				if(numeros[j]>numeros[j+1]) {
					long aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
				}
			}
		}
        long tFin = System.nanoTime();
		System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tInicio));
	}
    
    public static void ordenacionBurbuja3(long []numeros) {
       long tInicio = System.nanoTime();
       int i=1;
 	   do {
 		   
 		   for(int j=0; j<numeros.length-i; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						long aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
 		   
 		   i=1+i;
 	   } while(i<numeros.length);
 	    long tFin = System.nanoTime();
		System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tInicio));
    }
	
}

class OrdenamientoQuickSort{
	
	private static void quicksort(int a[], int primero, int ultimo)
	{
		 int i, j, central;
		 int pivote;
		 central = (primero + ultimo)/2;
		 pivote = a[central];
		 i = primero;
		 j = ultimo;
		 do {
		 	 while (a[i] < pivote) i++;
		 	 while (a[j] > pivote) j--;
		 	 if (i <= j)
		 	 {
		 		 // Se intercambian
		 		 int aux = a[i];
				 a[i] = a[j];
				 a[j] = aux;
		 	 	 i++;
		 	 	 j--;
		 	 }
		 } while (i <= j);
		 
		 if (primero < j)
		 	 quicksort(a, primero, j); // mismo proceso con sublista izqda
		 if (i < ultimo)
		 	 quicksort(a, i, ultimo); // mismo proceso con sublista drcha
	}
	
	public static void quicksort(int a[])
	{
		long tFin, tInicio = System.currentTimeMillis();
		quicksort(a, 0, a.length-1);
		tFin = System.currentTimeMillis();
		System.out.println("\nTiempo de ordenamiento: " + (tFin -tInicio));
	}
	
	
	// ------------- Ordenamiento de objetos --------------
	
	private static void quicksort(Alumno a[], int primero, int ultimo)
	{
		 int i, j, central;
		 Alumno pivote;
		 central = (primero + ultimo)/2;
		 pivote = a[central];
		 i = primero;
		 j = ultimo;
		 do {
		 	 while (a[i].getPromedio() < pivote.getPromedio()) i++;
		 	 while (a[j].getPromedio() > pivote.getPromedio()) j--;
		 	 if (i <= j)
		 	 {
		 		 Alumno aux = a[i];
				 a[i] = a[j];
				 a[j]= aux ;
		 	 	 i++;
		 	 	 j--;
		 	 }
		 }while (i <= j);
		 if (primero < j)
		 	 quicksort(a, primero, j); // mismo proceso con sublista izqda
		 if (i < ultimo)
		 	 quicksort(a, i, ultimo); // mismo proceso con sublista drcha
	}
	
	public static void quicksort(Alumno a[])
	{
		long tFin, tInicio = System.currentTimeMillis();
		
		quicksort(a, 0, a.length-1);
	
		tFin = System.currentTimeMillis();
		System.out.println("\nTiempo de ordenamiento: " + (tFin -tInicio));
	}
}

public class PruebaAlgoritmosOrdenamiento {
	public static void main(String[] args) {
		
		/*
		Random random = new Random();
		
		int [] vector = new int[10];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = 10 + random.nextInt((100 - 30) + 1);
		}
		
		System.out.println(Arrays.toString(vector));
		
		OrdenamientoQuickSort.quicksort(vector);
		
		
		System.out.println(Arrays.toString(vector));
		
		Alumno alumnos[] = {new Alumno("Pablo", "ISC", 90), new Alumno("Paco", "isc", 100), new Alumno("Pedro", "ADM", 50)};
		
		System.out.println();
		System.out.println(Arrays.toString(alumnos));
		
		OrdenamientoQuickSort.quicksort(alumnos);
		System.out.println(Arrays.toString(alumnos));
		*/
	}
}
