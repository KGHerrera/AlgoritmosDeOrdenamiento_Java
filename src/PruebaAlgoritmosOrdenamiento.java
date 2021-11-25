import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class AlgoritmosOrdenamiento{
	
	 public static void burbuja1(int []numeros) {
			
  	   long tInicio = System.currentTimeMillis();
			for(int i=1; i<=numeros.length-1; i++) {
				
				for(int j=0; j<=numeros.length-i-1; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
		long tFin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tInicio));
	}
	
	public static void burbuja2(int []numeros) {
    	int i = 1;
    	while(i<numeros.length) {
    		for(int j = 0; j < numeros.length-i; j++) {
    			if(numeros[j] > numeros[j+1]) {
    				int aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
    			}
    		}
    		i = i + 1;
    		
    	}
	}
    
    public static void burbuja3(int []numeros) {
       long tInicio = System.currentTimeMillis();
       int i=1;
 	   do {
 		   
 		   for(int j=0; j<numeros.length-i; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
 		   
 		   i=1+i;
 	   } while(i<numeros.length);
 	    long tFin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tInicio));
    }
	
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
		 	 if (i <= j) {
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
		 Alumno pivote; // cambiar pivote por el tipo de dato a ordenar
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
		 } while (i <= j);
		 if (primero < j)
		 	 quicksort(a, primero, j); // mismo proceso con sublista izqda
		 if (i < ultimo)
		 	 quicksort(a, i, ultimo); // mismo proceso con sublista drcha
	}
	
	public static void quicksort(Alumno a[]) {
		long tFin, tInicio = System.currentTimeMillis();
		
		quicksort(a, 0, a.length-1);
	
		tFin = System.currentTimeMillis();
		System.out.println("\nTiempo de ordenamiento: " + (tFin -tInicio));
	}
	
	// ----------- ShellSort ---------------
	
	public static void ordenacionShell(int a[]) {
		 int intervalo, i, j, k;
		 int n= a.length;
		 intervalo = n / 2;
		 while (intervalo > 0)
		 {
		 	 for (i = intervalo; i < n; i++)
		 	 {
		 	 	 j = i - intervalo;
		 	 	 while (j >= 0)
		 	 	 {
		 	 	 	 k = j + intervalo;
		 	 	 	 if (a[j] <= a[k])
		 	 	 	 	 j = -1; // par de elementos ordenado
		 	 	 	 else
		 	 	 	 {
		 	 	 	 	 intercambiar(a, j, j+1);
		 	 	 	 	 j -= intervalo;
		 	 	 	 }
		 	 	 }
		 	 }
		 	 intervalo = intervalo / 2;
		 }
	}
	
	public static void intercambiar(int []a, int i, int j) {
		 int aux = a[i];
		 a[i] = a[j];
		 a[j]= aux ;
	}
	
	// Radix
	
	public static void radix(int []nums) {
		int[][] bucket = new int[10][nums.length];
		int[] bucketOfElement = new int[10];
		int max=0;
	
		for(int i = 0 ; i < nums.length;i++) {
			if(nums[i]>max){
				max = nums[i];
			}
		}
		
		int maxLength = (max+"").length();
		for(int m = 0,n=1;m<maxLength;m++,n*=10) {
		
			for(int i = 0 ; i < nums.length;i++) {
				int digit = nums[i]/n%10;
			
				bucket[digit][bucketOfElement[digit]] = nums[i];
				bucketOfElement[digit]++;
			}
			int index = 0;
			
			for(int j = 0;j<10;j++) {
				for(int k = 0 ; k<bucketOfElement[j];k++) {
					nums[index] = bucket[j][k];
					index++;
				}
				bucketOfElement[j]=0;
			}
		}
	}
	
	
}

class Alumno {
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

public class PruebaAlgoritmosOrdenamiento {
	public static void main(String[] args) {
		
		
		Random random = new Random();
		
		int [] vect = new int[10];
		for (int i = 0; i < vect.length; i++) {
			vect[i] = random.nextInt(100) + 1;
		}
		
		
		
		int opcion = 0;
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("\nIntroduce metodo de ordenamiento: ");
			System.out.println("1) burbuja 1");
			System.out.println("2) burbuja 2");
			System.out.println("3) burbuja 3");
			System.out.println("4) Quicksort");
			System.out.println("5) Shellsort");
			System.out.println("6) Radix");
			System.out.println("7) Salir");
			System.out.println("Introduce opcion: ");
			opcion = entrada.nextInt();
			
			int vector[] = vect.clone(); 
			
			
			switch (opcion) {
				
			case 1:
				System.out.println("\nVector sin ordenar");
				System.out.println(Arrays.toString(vector));
				
				AlgoritmosOrdenamiento.burbuja1(vector);
				System.out.println("\nVector ordenado: ");
				
				System.out.println(Arrays.toString(vector));
				
				break;
				
			case 2:
				System.out.println("\nVector sin ordenar");
				System.out.println(Arrays.toString(vector));
				
				AlgoritmosOrdenamiento.burbuja2(vector);
				System.out.println("\nVector ordenado: ");
				
				System.out.println(Arrays.toString(vector));
				break;
				
			case 3:
				System.out.println("\nVector sin ordenar");
				System.out.println(Arrays.toString(vector));
				
				AlgoritmosOrdenamiento.burbuja3(vector);
				System.out.println("\nVector ordenado: ");
				
				System.out.println(Arrays.toString(vector));
				break;
				
			case 4:
				System.out.println("\nVector sin ordenar");
				System.out.println(Arrays.toString(vector));
				
				AlgoritmosOrdenamiento.quicksort(vector);
				System.out.println("\nVector ordenado: ");
				
				System.out.println(Arrays.toString(vector));
				break;
				
			case 5:
				System.out.println("\nVector sin ordenar");
				System.out.println(Arrays.toString(vector));
				
				AlgoritmosOrdenamiento.ordenacionShell(vector);
				System.out.println("\nVector ordenado: ");
				
				System.out.println(Arrays.toString(vector));
				break;
			case 6:
				System.out.println("\nVector sin ordenar");
				System.out.println(Arrays.toString(vector));
				
				AlgoritmosOrdenamiento.radix(vector);
				System.out.println("\nVector ordenado: ");
				
				System.out.println(Arrays.toString(vector));
				break;
				
			case 7:
				System.out.println("\nSaliendo . . .");
				break;
			default:
				System.out.println("\nOpcion incorrecta");
				break;
			}
			
		} while(opcion != 7);
		
		
		
		
		
		/*
		
		System.out.println("\nQuickSort");
		System.out.println("Vector sin ordenar");
		System.out.println(Arrays.toString(vector));
		
		AlgoritmosOrdenamiento.quicksort(vector);
		System.out.println("\nVector ordenado: ");
		
		System.out.println(Arrays.toString(vector));
		
		Alumno alumnos[] = {new Alumno("Pablo", "ISC", 90), new Alumno("Paco", "isc", 100), new Alumno("Pedro", "ADM", 50)};
		
		System.out.println("\nVector sin ordenar");
		System.out.println(Arrays.toString(alumnos));
		
		System.out.println("\nVector ordenado: ");
		AlgoritmosOrdenamiento.quicksort(alumnos);
		System.out.println(Arrays.toString(alumnos));
		
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = random.nextInt(100) + 1;
		}
		
		System.out.println("\nShellsort");
		System.out.println("Vector sin ordenar");
		System.out.println(Arrays.toString(vector));
		
		AlgoritmosOrdenamiento.ordenacionShell(vector);
		System.out.println("\nVector ordenado: ");
		System.out.println(Arrays.toString(vector));
		*/
		
	}
}
