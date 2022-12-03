package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Asistencia> asistencias;

	public Sistema() {
		super();
		this.asistencias = new ArrayList<Asistencia>();
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	@Override
	public String toString() {
		return "Sistema [asistencias=" + asistencias + "]";
	}
	//**********
	public boolean agregarTrabajoPresencial(LocalDate fecha, String legajo, LocalTime horaDesde, LocalTime horaHasta) throws Exception {
		if (traerAsistencia(fecha,legajo) != null) throw new Exception("Ya existe");//valida que aún no exista una asistencia para la misma fecha y legajo
		int maxId=1;
		if(!asistencias.isEmpty()) maxId=asistencias.get(asistencias.size()-1).getIdAsistencia()+1;//busco el id del ultimo de la lista y le sumo 1
		return asistencias.add(new TrabajoPresencial(maxId,legajo,fecha,horaDesde,horaHasta));
	}
	public boolean agregarTeletrabajo(LocalDate fecha, String legajo, String motivo, int tareasRealizadas) throws Exception {
		int maxId=1;
		if(!asistencias.isEmpty()) maxId=asistencias.get(asistencias.size()-1).getIdAsistencia()+1;//busco el id del ultimo de la lista y le sumo 1
		return asistencias.add(new Teletrabajo(maxId,legajo,fecha,motivo,tareasRealizadas));
	}
	public Asistencia traerAsistencia(LocalDate fecha, String legajo) {
		Asistencia asistencia = null;
		int i=0;
		while (i<asistencias.size() && asistencia ==null) {
			if (asistencias.get(i).getFecha().equals(fecha) && asistencias.get(i).getLegajo().equals(legajo)) {
				asistencia=asistencias.get(i);
			}
			i++;
		}
		return asistencia;
	}
	public List<Asistencia> traerAsistencia(LocalDate fecha){
		List<Asistencia> lstAux= new ArrayList<Asistencia>();
		for (Asistencia asistencia: asistencias) {
			if (asistencia.getFecha().equals(fecha)) lstAux.add(asistencia);//si coincide la fecha lo añado a la lista
		}
		return lstAux;
	}
	public List<Asistencia> traerAsistencia(boolean esPresencial){
		List<Asistencia> lstAux= new ArrayList<Asistencia>();
		for(Asistencia asistencia: asistencias) {
			if (esPresencial && asistencia instanceof TrabajoPresencial) lstAux.add(asistencia);//si el parametro pide presencial agrego a la lista los TrabajosPresenciales
			if (!esPresencial && asistencia instanceof Teletrabajo) lstAux.add(asistencia);//si el parametro pide los que NO son presenciales agrego a la lista los Teletrabajos
		}
		return lstAux;
	}
	
	
}
