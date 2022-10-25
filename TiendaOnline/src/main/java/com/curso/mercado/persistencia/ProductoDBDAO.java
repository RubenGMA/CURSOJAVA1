package com.curso.mercado.persistencia;


import java.lang.reflect.UndeclaredThrowableException;
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
			
			try {
				int newID = this.getUltimoIdProducto()+1;
				String insertar = "INSERT INTO HR.PRODUCTOS "+
						"(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK) "+
						"VALUES (?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(insertar);
				ps.setInt(1, newID);
				ps.setString(2, entidad.getDescripcion());
				ps.setDouble(3, entidad.getPrecio());
				ps.setInt(4, entidad.getStock());
				ps.executeUpdate();
				System.out.println("grabó ok el producto");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("No se pudo crear producto" + e.getMessage(),e);
			}
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
		return productos;
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
	
	private int getUltimoIdProducto() {
		String consulta = "SELECT max(ID_PRODUCTO) FROM HR.PRODUCTOS";
		try {
			ResultSet rs = con.createStatement().executeQuery(consulta);
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("No pudo cargar el ultimo id");
		}
		
	}

}
