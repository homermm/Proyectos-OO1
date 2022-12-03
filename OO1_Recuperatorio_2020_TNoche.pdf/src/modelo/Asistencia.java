package modelo;

import java.time.LocalDate;

public abstract class Asistencia {
	protected int idAsistencia;// Es un identificador único. Se tiene que calcular automáticamente, arrancando en 1
	protected String legajo;
	protected LocalDate fecha;
	
	public Asistencia(int idAsistencia, String legajo, LocalDate fecha) {
		super();
		this.idAsistencia = idAsistencia;
		this.legajo = legajo;
		this.fecha = fecha;
	}
	public int getIdAsistencia() {
		return idAsistencia;
	}
	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "\nAsistencia [idAsistencia=" + idAsistencia + ", legajo=" + legajo + ", fecha=" + fecha + "]";
	}
	//*********
	public abstract double calcularHorasTrabajadas();
	
}
