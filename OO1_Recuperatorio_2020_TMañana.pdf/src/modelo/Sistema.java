package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Pedido> pedidos;

	public Sistema() {
		super();
		this.pedidos = new ArrayList<Pedido>();
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	@Override
	public String toString() {
		return "Sistema [pedidos=" + pedidos + "]";
	}
	//*************
	public boolean agregarPedidoPapelMensual(LocalDate fechaCreacion,double montoBase,LocalDate fechaEntrega,int cantidadResmas) throws Exception {
		int maxId=1;
		if(!pedidos.isEmpty()) maxId= pedidos.get(pedidos.size()-1).getIdPedido()+1;//busco el id del ultimo de la lista y le sumo 1
		return pedidos.add(new PedidoPapelMensual(maxId, fechaCreacion, montoBase, fechaEntrega, cantidadResmas));
	}
	public boolean agregarPedidoElectronico(LocalDate fechaCreacion,double montoBase,String motivo,double porcentajeExtra) throws Exception {
		int maxId=1;
		if(!pedidos.isEmpty()) maxId= pedidos.get(pedidos.size()-1).getIdPedido()+1;//busco el id del ultimo de la lista y le sumo 1
		return pedidos.add(new PedidoElectronico(maxId, fechaCreacion, montoBase, motivo, porcentajeExtra));
	}
	public Pedido traerPedido(int idPedido) {
		Pedido pedido = null;
		int i=0;
		while (i<pedidos.size() && pedido==null) {
			if(pedidos.get(i).getIdPedido()==idPedido) pedido=pedidos.get(i);
			i++;
		}
		return pedido;
	}
	public List<Pedido> traerPedido(String motivo) {
		List<Pedido> lstAux = new ArrayList<Pedido>();
		for (Pedido pedido: pedidos) {
			if (pedido instanceof PedidoElectronico) {
				PedidoElectronico p = (PedidoElectronico) pedido;
				if(p.getMotivo().equals(motivo)) lstAux.add(p);
			}
		}
		return lstAux;
	}
	public double calcularTotalGeneral() {
		double total =0;
		for (Pedido pedido: pedidos) {
			total+= pedido.calcularPrecioFinal();
		}
		return total;
	}
	
}
