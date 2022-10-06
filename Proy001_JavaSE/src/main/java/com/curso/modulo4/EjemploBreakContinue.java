package com.curso.modulo4;

public class EjemploBreakContinue {
	
	public static void main(String[] args) {
		//break y continue
		int b = 7;
		int c = 7;
		//casi 1. BREAK
		System.out.println("caso 1 BREAK");
		for(int i = 2; i < b ; i++) {
			System.out.println(" linea "+i);
			if ( i == 4 ) break;
			System.out.println(" y escribo esto ");
		}
		//caso 2. Continue
		System.out.println("caso 2 CONTINUE");
		for(int i = 2; i < c ; i++) {
			System.out.println(" linea "+i);
			if ( i == 4 ) continue;
			System.out.println(" y escribo esto ");
		}
		//caso 3. break anidado sin etiqueta
		System.out.println("caso 3. break anidado sin etiqueta");
		for(int i = 2; i < c ; i++) {
			System.out.println(" linea "+i);

			for( int j=0; j<3; j++) {
				System.out.println(j);
				if(i==4) break;
				System.out.println(" y escribo esto ");
			}
			System.out.println("------ Bucle externo ------");
		}
		//caso 5. continue anidado con etiqueta
				System.out.println("caso 4. continue anidado con etiqueta");
				forexterno:
				for (int i = 2; i < c; i++) {
					System.out.println(" linea " + i);

					for (int j = 0; j < 3; j++) {
						System.out.println(j);
						if (i == 4)
							continue forexterno;
						System.out.println(" y escribo esto");
					}
					System.out.println("------ Bucle externo ------");
				}
	}
}
