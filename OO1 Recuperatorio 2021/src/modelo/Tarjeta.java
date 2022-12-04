package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tarjeta {
	private int idTarjeta;
	private String codigo;
	private String codigoCliente;
	private List<Compra> compras;
	
	public Tarjeta(int idTarjeta, String codigo, String codigoCliente) throws Exception {
		super();
		this.idTarjeta = idTarjeta;
//		this.codigo = codigo;
		this.setCodigo(codigo);
		this.codigoCliente = codigoCliente;
		this.compras = new ArrayList<Compra>();
	}
	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) throws Exception {
		if(!esValido(codigo)) throw new Exception ("El codigo no es valido");
		this.codigo = codigo;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	@Override
	public String toString() {
		return "\nTarjeta [idTarjeta=" + idTarjeta + ", codigo=" + codigo + ", codigoCliente=" + codigoCliente + "]";
	}
	//***************
	public boolean esValido(String codigo) {
		int letra=0;
		int numero=0;
	
		for (int i=0;i<12;i++) {
			if(Character.isLetter(codigo.charAt(i))) letra++;
			if(Character.isDigit(codigo.charAt(i))) numero++;
		}
		
		return (letra==6 && numero==6);
	}
	
	public boolean agregarCompra(LocalDate fecha,LocalTime hora,double puntosPorLitro, double litrosComprados, double puntosExtra) {
		int maxId=1;
		if(!compras.isEmpty()) maxId= compras.get(compras.size()-1).getIdCompra()+1;
		return compras.add(new Efectivo(maxId,fecha,hora,puntosPorLitro,litrosComprados,puntosExtra));
	}
	public boolean agregarCompra(LocalDate fecha,LocalTime hora,double puntosPorLitro,double litrosComprados,String medio,double puntosDeRegalo) {
		int maxId=1;
		if(!compras.isEmpty()) maxId= compras.get(compras.size()-1).getIdCompra()+1;
		return compras.add(new Electronica(maxId,fecha,hora,puntosPorLitro,litrosComprados,medio,puntosDeRegalo));
	}
	public double calcularPuntaje() {
		double suma=0;
		for (Compra compra: compras) {
			suma+= compra.calcularPuntajeFinal();
		}
		return suma;
	}
	public double calcularPuntaje(LocalDate fecha) {
		double suma=0;
		for (Compra compra: compras) {
			if(compra.getFecha().equals(fecha)) {
				suma+=compra.calcularPuntajeFinal();
			}
		}
		return suma;
	}
	public double calcularPuntaje(int anio,int mes) {
		double suma=0;
		for (Compra compra: compras) {
			if(compra.getFecha().getYear()==anio && compra.getFecha().getDayOfMonth()==mes) {
				suma+=compra.calcularPuntajeFinal();
			}
		}
		return suma;
	}
	
}
