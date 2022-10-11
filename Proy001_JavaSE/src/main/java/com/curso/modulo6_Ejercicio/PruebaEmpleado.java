package com.curso.modulo6_Ejercicio;

import java.util.Date;
import com.curso.modulo6_Ejercicio.Empleado;

public class PruebaEmpleado {
	public static void main(String[] args) {
//		Empleado e = new Empleado();
//		e.setNombre("Luis");
//		e.setSalario(20000.0);
//
//		Gerente g = new Gerente();
//		g.setNombre("Carlos");
//		g.setSalario(23423.0);
//		g.setDepartamento("Informatica");
//
//		System.out.println(e.getDetails());
//		System.out.println(g.getDetails());
//
//		Secretario a = new Secretario();
//		a.setNombre("Roberto");
//		a.setSalario(22000.0);
//		System.out.println(a.getDetails());
//
//		// una variable de referencia puede apuntar
//		// a objetos de su clase o clases hijas
//
//		Empleado carlos = new Gerente();
//
//		carlos.setNombre("Carlos");
//		carlos.setSalario(45000);
		// carlos.setDepartamento();
		// carlos tiene forma empleado por lo tanto solo permite
		// acceder a los atributos y metodos de empleado

		Empleado mario = new Empleado("Mario", 34000.0, new Date());
		
		Gerente g2 = new Gerente("Juan",35000.0,new Date(),"infor");
	}
}
