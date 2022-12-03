package modelo;

import java.time.LocalDate;

public class Teletrabajo extends Asistencia{
	private String motivo;
	private int tareasRealizadas;// No pueden realizarse más de 8 tareas diarias, lanza excepción
	
	public Teletrabajo(int idAsistencia, String legajo, LocalDate fecha, String motivo, int tareasRealizadas) throws Exception {
		super(idAsistencia, legajo, fecha);
		this.motivo = motivo;
//		this.tareasRealizadas = tareasRealizadas;
		this.setTareasRealizadas(tareasRealizadas);
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public int getTareasRealizadas() {
		return tareasRealizadas;
	}
	public void setTareasRealizadas(int tareasRealizadas) throws Exception {
		if(tareasRealizadas>8) throw new Exception("No pueden realizarse mas de 8 tareas diarias");
		this.tareasRealizadas = tareasRealizadas;
	}
	@Override
	public String toString() {
		return super.toString()+"Teletrabajo [motivo=" + motivo + ", tareasRealizadas=" + tareasRealizadas + "]";
	}
	//******************
	@Override
	public double calcularHorasTrabajadas() {
		return tareasRealizadas*1.5;//Cada tarea realizada equivale a 1,5 horas.
	}
	
}
