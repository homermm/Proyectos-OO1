package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemasCallCenter {
	private List<Llamada> lstLlamadas;
	private List<Persona> lstPersonas;
	public SistemasCallCenter() {
		super();
		this.lstLlamadas = new ArrayList<Llamada>();
		this.lstPersonas = new ArrayList<Persona>();
	}
	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}
	public void setLstLlamadas(List<Llamada> lstLlamadas) {
		this.lstLlamadas = lstLlamadas;
	}
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	@Override
	public String toString() {
		return "SistemasCallCenter [lstLlamadas=" + lstLlamadas + ", lstPersonas=" + lstPersonas + "]";
	}
	//*****************
	public Persona traerPersona(long dni) {
		Persona persona = null;
		int i=0;
		while(i<lstPersonas.size() && persona==null) {
			if (lstPersonas.get(i).getDni()==dni) persona = lstPersonas.get(i);
			i++;
		}
		return persona;
	}
	public boolean agregarCliente(String nombre, String apellido, long dni, LocalDate fechaDeAlta, boolean activo) throws Exception {
		if (traerPersona(dni) != null) throw new Exception("Esta persona ya existe");
		int maxId=1;
		if(!lstPersonas.isEmpty()) maxId=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		return lstPersonas.add(new Cliente(maxId, nombre, apellido, dni, fechaDeAlta, activo));
	}
	public boolean agregarEmpleado(String nombre, String apellido, long dni, LocalDate fechaDeAlta, int sueldoBase) throws Exception {
		if (traerPersona(dni) != null) throw new Exception("Esta persona ya existe");
		int maxId=1;
		if(!lstPersonas.isEmpty()) maxId=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		return lstPersonas.add(new Empleado(maxId, nombre, apellido, dni, fechaDeAlta, sueldoBase));
	}
	public boolean agregarLlamada(LocalDate fecha, LocalTime hora, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion) throws Exception {
		int maxId=1;
		if(!lstLlamadas.isEmpty()) maxId=lstLlamadas.get(lstLlamadas.size()-1).getIdLlamada()+1;
		return lstLlamadas.add(new Llamada(maxId, fecha, hora, cliente, empleado, nivelDeSatisfaccion));
	}
	public List<Cliente> traerClientes(boolean estadoCliente){
		List<Cliente> lstAux= new ArrayList<Cliente>();
		for (Persona persona: lstPersonas) {
			if (persona instanceof Cliente) {
				Cliente cliente = (Cliente) persona;
				if(cliente.isActivo())lstAux.add((Cliente)persona);
			}
		}
		return lstAux;
	}
	public List<Persona> traerPersonasAntiguedad(int mayorIgualA){
		List<Persona> lstAux = new ArrayList<Persona>();
		for (Persona persona: lstPersonas) {
			if (persona.antiguedadEnAnios()>=mayorIgualA) {
				lstAux.add(persona);
			}
		}
		return lstAux;
	}
	public List<Llamada> traerllamadas(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta){
		List<Llamada> lstAux = new ArrayList<Llamada>();
		for (Llamada llamada: lstLlamadas) {
			if (llamada.getFecha().equals(fecha)){
				if(llamada.getHora().equals(horaDesde)||llamada.getHora().isAfter(horaDesde)&&llamada.getHora().isBefore(horaHasta)||llamada.getHora().equals(horaHasta)) {
					lstAux.add(llamada);
				}
			}
		}
		return lstAux;
	}
	
}
