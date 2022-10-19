package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Campamento extends Servicio{
	private LocalDate fechaEgreso;
	private int cantCarpas;
	private double precioCarpa;
	public Campamento(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable,
			LocalDate fechaEgreso, int cantCarpas, double precioCarpa) throws Exception {
		super(idServicio, codIngreso, fechaIngreso, checkOut, responsable);
		this.fechaEgreso = fechaEgreso;
		this.cantCarpas = cantCarpas;
		this.precioCarpa = precioCarpa;
	}
	public LocalDate getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(LocalDate fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	public int getCantCarpas() {
		return cantCarpas;
	}
	public void setCantCarpas(int cantCarpas) {
		this.cantCarpas = cantCarpas;
	}
	public double getPrecioCarpa() {
		return precioCarpa;
	}
	public void setPrecioCarpa(double precioCarpa) {
		this.precioCarpa = precioCarpa;
	}
	@Override
	public String toString() {
		return super.toString()+"Campamento [fechaEgreso=" + fechaEgreso + ", cantCarpas=" + cantCarpas + ", precioCarpa=" + precioCarpa
				+ "]";
	}
	//**********
	//CU 6
	public int cantidadDias() {
		LocalDate aux= LocalDate.now();
		if (checkOut) aux=fechaEgreso;
		return Period.between(fechaIngreso, aux).getDays();
	}
	//CU7
	@Override
	public double calcularPrecioFinal() {
		return cantCarpas*precioCarpa*cantidadDias();
	}
	
	
}
