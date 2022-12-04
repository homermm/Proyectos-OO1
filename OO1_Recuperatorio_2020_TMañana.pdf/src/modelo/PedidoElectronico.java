package modelo;

import java.time.LocalDate;

public class PedidoElectronico extends Pedido {
	private String motivo;
	private double porcentajeExtra;
	public PedidoElectronico(int idPedido, LocalDate fechaCreacion, double montoBase, String motivo,
			double porcentajeExtra) throws Exception {
		super(idPedido, fechaCreacion, montoBase);
//		this.motivo = motivo;
		this.setMotivo(motivo);//no debe ser vacio
		this.porcentajeExtra = porcentajeExtra;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) throws Exception {
		if(motivo.isEmpty()) throw new Exception("El motivo no debe estar vacio");
		this.motivo = motivo;
	}
	public double getPorcentajeExtra() {
		return porcentajeExtra;
	}
	public void setPorcentajeExtra(double porcentajeExtra) {
		this.porcentajeExtra = porcentajeExtra;
	}
	@Override
	public String toString() {
		return super.toString()+"PedidoElectronico [motivo=" + motivo + ", porcentajeExtra=" + porcentajeExtra + "]";
	}
	//***********
	@Override
	public double calcularPrecioFinal() {
		// TODO Auto-generated method stub
		return super.montoBase*porcentajeExtra;
	}
	
}
