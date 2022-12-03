package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrabajoPresencial extends Asistencia {
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	
	public TrabajoPresencial(int idAsistencia, String legajo, LocalDate fecha, LocalTime horaDesde,
			LocalTime horaHasta) {
		super(idAsistencia, legajo, fecha);
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}
	public LocalTime getHoraDesde() {
		return horaDesde;
	}
	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}
	public LocalTime getHoraHasta() {
		return horaHasta;
	}
	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}
	@Override
	public String toString() {
		return super.toString()+"TrabajoPresencial [horaDesde=" + horaDesde + ", horaHasta=" + horaHasta + "]";
	}
	//************
	@Override
	public double calcularHorasTrabajadas() {
		return ((horaHasta.getHour()-horaDesde.getHour())*60+horaHasta.getMinute()-horaDesde.getMinute())*60;
	}
	
	
}
