package Modelo;

import java.util.List;
import java.util.ArrayList;

public class Supermercado {
	private List<Producto> lstProducto;
	private List<Cliente> lstCliente;
	private List<Carrito> lstCarrito;
	
	public Supermercado() {
		this.lstProducto = new ArrayList<Producto>();
		this.lstCliente = new ArrayList<Cliente>();
		this.lstCarrito = new ArrayList<Carrito>();
	}
	
	public boolean agregarProducto(String producto, float precio) throws Exception{
		int maxId=1;
		if (estaEnLaLista(producto)) throw new Exception("Ya existe en la lista");
		if (lstProducto.size()>0) {
			maxId=lstProducto.get(lstProducto.size()-1).getIdProducto()+1;
			}
			lstProducto.add(new Producto(maxId,producto,precio));
		return true;
	}

	public boolean estaEnLaLista(String producto) {
		boolean esta=false;
		for (Producto p: lstProducto) {
			if(p.getProducto()==producto) {
				esta=true;
			}
		}
		return esta;
	}
	
	public Producto traerProducto(int idProducto){
		Producto producto=null;
		for (Producto p: lstProducto) {
			if (p.getIdProducto()==idProducto) {
				producto=p;
			}
		}
		return producto;
	}
	//+ modificarProducto(int idProducto, String producto, double precio) : boolean
	public boolean modificarProducto(int idProducto, String producto, double precio) throws Exception {
		if(traerProducto(idProducto)==null) throw new Exception("EL PRODUCTO NO EXISTE");
		traerProducto(idProducto).setProducto(producto);
		traerProducto(idProducto).setPrecio((float)precio);
		return true;
	}
	//eliminarProducto(int idProducto) : boolean
	public boolean eliminarProducto(int idProducto) throws Exception{
		if(traerProducto(idProducto)==null) throw new Exception("El producto no existe");
		for (Producto p: lstProducto) {
			if (p.getIdProducto()==idProducto){
				lstProducto.remove(p);
				
			}
		}
		return true;
	}

	//SETTERS GETTERS
	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	@Override
	public String toString() {
		return "Supermercado [lstProducto=" + lstProducto + ", lstCliente=" + lstCliente + ", lstCarrito=" + lstCarrito
				+ "]";
	}
	
	
	
}
