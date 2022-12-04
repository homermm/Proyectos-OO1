package modelo;

import java.time.LocalDate;

public class PedidoPapelMensual extends Pedido {
	private LocalDate fechaEntrega;
	private int cantidadResmas;
	
	public PedidoPapelMensual(int idPedido, LocalDate fechaCreacion, double montoBase, LocalDate fechaEntrega,
			int cantidadResmas) throws Exception {
		super(idPedido, fechaCreacion, montoBase);
		this.fechaEntrega = fechaEntrega;
//		this.cantidadResmas = cantidadResmas;
		this.setCantidadResmas(cantidadResmas); //no puede ser 0
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getCantidadResmas() {
		return cantidadResmas;
	}
	public void setCantidadResmas(int cantidadResmas) throws Exception {
		if (cantidadResmas<1) throw new Exception("La cantidad de resmas debe ser mayor a 0");
		this.cantidadResmas = cantidadResmas;
	}
	@Override
	public String toString() {
		return super.toString()+"PedidoPapelMensual [fechaEntrega=" + fechaEntrega + ", cantidadResmas=" + cantidadResmas + "]";
	}
	
	//*************
	@Override
	public double calcularPrecioFinal() {
		// TODO Auto-generated method stub
		return super.montoBase*cantidadResmas;
	}
	
	
	
	
}
