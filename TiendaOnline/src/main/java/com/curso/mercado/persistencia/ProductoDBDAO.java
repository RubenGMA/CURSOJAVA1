package com.curso.mercado.persistencia;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.curso.mercado.entidades.Producto;

public class ProductoDBDAO implements GenericDAO<Producto>{
	
	private Connection con;
	
	public ProductoDBDAO(Connection con) {
				this.con = con;
	}

	@Override
	public void add(Producto entidad) {
			
	}

	@Override
	public List<Producto> getAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String consulta = "SELECT * FROM HR.PRODUCTOS";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt("ID_PRODUCTO"));
				p.setDescripcion(rs.getString("DESCRIPCION"));
				p.setPrecio(rs.getDouble("PRECIO"));
				p.setStock(rs.getInt("STOCK"));
				productos.add(p);
			}
			
			
		} catch (SQLException e) {
			//e.printStackTrace();
			//lanzamos una nueva excepcion pero le pasamos e(throwable), para que no pierda la pila de llamadas
			//de quien lanzó la primera excepcion
			throw new RuntimeException(
					"DB JDBC API." + e.getMessage(), e);					
		}
		return null;
	}

	@Override
	public Producto getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
				
	}

	@Override
	public void update(Producto entidad) {
				
	}

}
