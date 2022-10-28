package com.curso.spring.ejemplo002;

import org.springframework.stereotype.Service;

@Service
public class IRPFServiceImp implements IRPFService{

	public IRPFServiceImp() {
		System.out.println("..... Instanciando IRPFServiceImp");
	}
	@Override
	public double calcularIRPF() {
		
		return 10.0;
	}

}
