package com.curso.spring.configuracion;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
// para importar beans y buscar beans de otras configuracones antiguas o diferentes...
// @ComponentScan(basePackages = "com.curso")
// @ImportResource("classpath:mis-beans.xml") //en resources
// Para otra clase configuration: @Import(OtraJavaConfig.class)
public class ConfigurarBeansApp {

	@Bean //es singelton por defecto
	public JefeEquipo jefe1() {
		return new JefeEquipo();
	}
	
	@Bean
	public Programador programador1() {
		Programador p = new Programador();
		p.setTarea("Programo en PLSQL");
		return p;
	}
	
	@Bean	
	public Programador programadorJava() {
		Programador p = new Programador();
		p.setTarea("Programo en Java");
		return p;
	}
	
	@Bean	
	@Scope(value = "prototype")
	public Programador programador3() {
		Programador p = new Programador();
		p.setTarea("Programo en Java");
		return p;
	}
}
