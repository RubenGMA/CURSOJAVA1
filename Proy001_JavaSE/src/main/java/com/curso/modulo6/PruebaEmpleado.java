package com.curso.modulo6;

public class PruebaEmpleado {
	public static void main(String[] args) {
		Empleado e = new Empleado();
		e.setNombre("Luis Ramos");
		e.setSalario(40000);

		Gerente g = new Gerente();
		g.setNombre("Begoña Olea");
		g.setDepartamento("Desarrollo");
		g.setSalario(70000);
		
		System.out.println("g es un gerente? "+
					(g instanceof Gerente));
		System.out.println("g es un empleado? "+
				(g instanceof Empleado));
		System.out.println("e es un gerente? "+
				(e instanceof Gerente));
		
		//una variable de referencia puede apuntar
		//a objetos de su clase o clases hijas
		
		Empleado carlos = new Gerente();
		
		carlos.setNombre("Carlos");
		carlos.setSalario(45000);
		//carlos.setDepartamento();
		//carlos tiene forma empleado por lo tanto solo permite
		//acceder a los atributos y metodos de empleado
		
	}
}
