package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Mercancia> lstMercancia;

	public Sistema() {
		super();
		this.lstMercancia = new ArrayList<Mercancia>();
	}

	public List<Mercancia> getLstMercancia() {
		return lstMercancia;
	}

	public void setLstMercancia(List<Mercancia> lstMercancia) {
		this.lstMercancia = lstMercancia;
	}

	@Override
	public String toString() {
		return "Sistema [lstMercancia=" + lstMercancia + "]";
	}
	//**********
	public Mercancia traerMercancia(String codMercancia) {
		Mercancia mercancia = null;
		int i=0;
		while (i<lstMercancia.size() && mercancia ==null) { //itera hasta que lo encuentra o llega al fin de la lista
			if(lstMercancia.get(i).getCodMercancia().equals(codMercancia)) mercancia=lstMercancia.get(i);
			i++;
		}
		return mercancia;
	}
	public List<Mercancia> traerMercancia(boolean enOferta){
		List<Mercancia> lstAux = new ArrayList<Mercancia>();
		for(Mercancia m: lstMercancia) {
			if (m instanceof Producto) {
				Producto producto = (Producto) m; //lo casteo para acceder a la clase hija
				if (producto.isEsDescuentoEn2daUnidad()) lstAux.add(producto); //si esta en descuento la agrego
			}
			if (m instanceof Servicio) {
				Servicio servicio = (Servicio) m; //lo casteo para acceder a la clase hija
				if (servicio.isEnPromocion()) lstAux.add(servicio);//si esta en promocion la agrego
			}
		}
		return lstAux;
	}
	public boolean agregarProducto(String codMercancia, String producto, double precioProducto, double porcentajeDescuento, boolean esDescuentoEn2daUnidad) throws Exception {
		if(traerMercancia(codMercancia)!=null) throw new Exception("El producto ya existe"); //compruebo de si esta el producto en la lista
		return lstMercancia.add(new Producto(codMercancia,producto,precioProducto,porcentajeDescuento,esDescuentoEn2daUnidad));
	}
	public boolean agregarServicio(String codMercancia, String servicio, double presupuesto, double porcentajeDescuento, boolean enPromocion) throws Exception {
		if(traerMercancia(codMercancia)!=null) throw new Exception("El producto ya existe"); //compruebo de si esta el producto en la lista
		return lstMercancia.add(new Servicio(codMercancia,servicio,presupuesto,porcentajeDescuento,enPromocion));
	}
	
}
