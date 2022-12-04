package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaYPF {
	private List<Tarjeta> tarjetas;

	public SistemaYPF() {
		super();
		this.tarjetas = new ArrayList<Tarjeta>();
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	@Override
	public String toString() {
		return "SistemaYPF [tarjetas=" + tarjetas + "]";
	}
	//***************
	public Tarjeta traerTarjeta(String codigoCliente) {
		Tarjeta tarjeta = null;
		int i=0;
		while(i<tarjetas.size() && tarjeta==null) {
			if (tarjetas.get(i).getCodigoCliente().equals(codigoCliente)) tarjeta=tarjetas.get(i);
			i++;
		}
		return tarjeta;
	}
	
	public boolean agregarTarjeta(String codigo,String codigoCliente) throws Exception {
		int maxId=1;
		if(!tarjetas.isEmpty()) maxId=tarjetas.get(tarjetas.size()-1).getIdTarjeta()+1;
		return tarjetas.add(new Tarjeta(maxId,codigo,codigoCliente));
	}
	public List<Tarjeta> traerTarjetasComprasEfectivo(LocalDate fechaDesde,LocalDate fechaHasta){
		List<Tarjeta> lstAux = new ArrayList<Tarjeta>();
		for (Tarjeta tarjeta: tarjetas) {
			boolean efectivo=false;
			int i=0;
			
			while(i<tarjeta.getCompras().size() && efectivo==false) {
				Compra aux = tarjeta.getCompras().get(i);
				if (aux.getFecha().equals(fechaDesde) || aux.getFecha().isAfter(fechaDesde)&&aux.getFecha().isBefore(fechaHasta)|| aux.getFecha().equals(fechaHasta)) {
					if (aux instanceof Efectivo) {
						lstAux.add(tarjeta);
						efectivo=true;
					}
				}
				i++;
			}
		}
		return lstAux;
	}
	
}
