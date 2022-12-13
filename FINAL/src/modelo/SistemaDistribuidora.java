package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaDistribuidora {
	private List<Tarifa> lstTarifa;
	private List<Lectura> lstLectura;
	private List<Cliente> lstCliente;
	public SistemaDistribuidora() {
		super();
		this.lstTarifa = new ArrayList<Tarifa>();
		this.lstLectura = new ArrayList<Lectura>();
		this.lstCliente = new ArrayList<Cliente>();
	}
	public List<Tarifa> getLstTarifa() {
		return lstTarifa;
	}
	public void setLstTarifa(List<Tarifa> lstTarifa) {
		this.lstTarifa = lstTarifa;
	}
	public List<Lectura> getLstLectura() {
		return lstLectura;
	}
	public void setLstLectura(List<Lectura> lstLectura) {
		this.lstLectura = lstLectura;
	}
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}
	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	@Override
	public String toString() {
		return "SistemaDistribuidora [lstTarifa=" + lstTarifa + ", lstLectura=" + lstLectura + ", lstCliente="
				+ lstCliente + "]";
	}
	//******************
	//CU1
	public boolean agregarCliente(long numeroCliente, String nombre, String apellido, int dni, int kWSubsidio) {
		int maxId=1;
		if(!lstCliente.isEmpty()) maxId= lstCliente.get(lstCliente.size()-1).getId()+1;
		return lstCliente.add(new ClienteResidencial(maxId, numeroCliente, nombre, apellido, dni, kWSubsidio));
	}
	//CU2
	public boolean agregarCliente(long numeroCLiente, long cuit, String razonSocial) {
		int maxId=1;
		if(!lstCliente.isEmpty()) maxId= lstCliente.get(lstCliente.size()-1).getId()+1;
		return lstCliente.add(new ClienteCorporativo(maxId, numeroCLiente, cuit, razonSocial));
	}
	//CU3
	public boolean agregarTarifa(int consumoDesde, int consumoHasta, double cargoFijo, double cargoVariable) {
		int maxId=1;
		if(!lstTarifa.isEmpty()) maxId= lstTarifa.get(lstTarifa.size()-1).getId()+1;
		return lstTarifa.add(new Tarifa(maxId, consumoDesde, consumoHasta, cargoFijo, cargoVariable));
	}
	//CU4
	public Cliente traerCliente(long numeroCliente) {
		Cliente cliente = null;
		int i=0;
		while(i<lstCliente.size() && cliente==null) {
			if(lstCliente.get(i).getNumeroCliente()==numeroCliente) cliente = lstCliente.get(i);
			i++;
		}
		return cliente;
	}
	//CU5
	public boolean agregarLectura(LocalDate fecha, Cliente cliente, int estadoMedidor) {
		int maxId=1;
		if(!lstLectura.isEmpty()) maxId= lstLectura.get(lstLectura.size()-1).getId()+1;
		return lstLectura.add(new Lectura(maxId, fecha, cliente, estadoMedidor) );
	}
	//CU6
	public Lectura traerLectura(int mes, int anio, Cliente cliente) {
		Lectura lectura = null;
		int i=0;
		while(i<lstLectura.size() && lectura==null) {
			if(lstLectura.get(i).getCliente().equals(cliente)) {
				if(lstLectura.get(i).getFecha().getMonthValue()==mes && lstLectura.get(i).getFecha().getYear()==anio) {
					lectura=lstLectura.get(i);
				}
			}
			i++;
		}
		return lectura;
	}
	//CU8
	public Tarifa traerTarifa(int consumo) {
		Tarifa tarifa=null;
		int i=0;
		while(i<lstTarifa.size() && tarifa==null) {
			if(lstTarifa.get(i).getConsumoDesde()<=consumo && consumo<=lstTarifa.get(i).getConsumoHasta() ) tarifa= lstTarifa.get(i);
			i++;
		}
		return tarifa;
	}
	//CU9
	public double calcularTotalACobrar(int mes, int anio, Cliente cliente) {
		double descuento=0;
		//1
		Lectura l1 = traerLectura(mes, anio, cliente);
		//2
		LocalDate aux = LocalDate.of(anio, mes, 1);
		aux = aux.minusMonths(1);
		Lectura l2 = traerLectura(aux.getMonthValue(),aux.getYear(),cliente);
		//3
		int consumo = l1.calcularConsumo(l2);
		//4
		Tarifa tarifa = traerTarifa(l1.calcularConsumo(l2));
		//5
		double totalVariable = tarifa.getCargoVariable()*consumo;
		//6
		if(cliente instanceof ClienteResidencial) {
			ClienteResidencial res = (ClienteResidencial) cliente;
			 descuento = tarifa.getCargoVariable()* res.getkWhSubsidio();
		}
		
		if(totalVariable>=descuento) {
			totalVariable=totalVariable-descuento;
		}else {
			totalVariable=0;
		}
		//7
		return tarifa.getCargoFijo()+totalVariable;
	}
	
}
