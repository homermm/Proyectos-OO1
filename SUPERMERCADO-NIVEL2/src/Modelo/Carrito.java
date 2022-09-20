package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem;
	private Cliente cliente;
	
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		this.idCarrito=idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.lstItem = new ArrayList<ItemCarrito>();
		this.cliente = cliente;
	}
	public boolean agregarItem(Producto producto, int cantidad) {
		boolean agregado=false;
		ItemCarrito itemAux=getItem(producto);
		
		if (lstItem.size()==0) {
			lstItem.add(new ItemCarrito(1,producto,cantidad));agregado=true;
		}
		else {
			itemAux.setCantidad(itemAux.getCantidad()+cantidad);
		}
		return agregado;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		boolean eliminado=false;
		ItemCarrito itemAux= getItem(producto);
		if(itemAux==null)throw new Exception("El item no existe");
		if(itemAux.getCantidad()==cantidad) {
			lstItem.remove(itemAux);
			eliminado=true;
		}
		else {
			itemAux.setCantidad(itemAux.getCantidad()-cantidad);
			eliminado=true;
		}
		return eliminado;
	}

	public ItemCarrito getItem(Producto producto) {
		ItemCarrito item=null;
		for (ItemCarrito i: lstItem) {
			if (i.getProducto().equals(producto)){
				item=i;
			}
		}
		return item;
	}
	
	//SETTERS Y GETTERS
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", lstItem=" + lstItem
				+ ", cliente=" + cliente + "]";
	}
	
	
	
	
}
