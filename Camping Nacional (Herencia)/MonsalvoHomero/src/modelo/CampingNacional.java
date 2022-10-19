package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CampingNacional {
	private List<Persona> lstPersonas;
	private List<Servicio> lstServicios;
	public CampingNacional() {
		super();
		this.lstPersonas = new ArrayList<Persona>();
		this.lstServicios = new ArrayList<Servicio>();
	}
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	public List<Servicio> getLstServicios() {
		return lstServicios;
	}
	public void setLstServicios(List<Servicio> lstServicios) {
		this.lstServicios = lstServicios;
	}
	@Override
	public String toString() {
		return "CampingNacional [lstPersonas=" + lstPersonas + ", lstServicios=" + lstServicios + "]";
	}
	
	//CU1
	public Persona traerPersona(long dni) {
		Persona persona= null;
		int i=0;
		while(i<lstPersonas.size() && persona==null) {
			if(lstPersonas.get(i).getDni()==dni) {
				persona=lstPersonas.get(i);
			}
			i++;
		}
		return persona;
	}
	
	//CU2
	public boolean agregarPersona(String apellido, String nombre, long dni) throws Exception {
		if(traerPersona(dni)!=null) throw new Exception("La persona ya existe");
		int maxId=1;
		
		if(!lstPersonas.isEmpty()) maxId= lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		return lstPersonas.add(new Persona(maxId, apellido,nombre,dni));
	}
	
	
	//CU4
	public boolean agregarRecreo(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable, int cantPersonas, double precioPersona) throws Exception {
		int maxId=1;
		if(!lstServicios.isEmpty()) maxId=lstServicios.get(lstServicios.size()-1).getIdServicio()+1;
		return lstServicios.add(new Recreo(maxId,codIngreso,fechaIngreso,checkOut,responsable,cantPersonas,precioPersona));
		
	}
	//CU 5
	public boolean agregarCampamento(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable, LocalDate fechaEgreso, int cantCarpas, double precioCarpa) throws Exception {
		int maxId=1;
		if(!lstServicios.isEmpty()) maxId=lstServicios.get(lstServicios.size()-1).getIdServicio()+1;
		return lstServicios.add(new Campamento(maxId,codIngreso, fechaIngreso,checkOut,responsable,fechaEgreso,cantCarpas, precioCarpa));
	}
	//CU8
	public List<Servicio> traerServiciosPorPrecioFinal(double mayorIgualA){
		List<Servicio> listAux= new ArrayList<Servicio>();
		for (Servicio s: lstServicios) {
			if (s.isCheckOut() && (s.calcularPrecioFinal()>=mayorIgualA)) {
				listAux.add(s);
			}
		}
		return listAux;
	}
	//CU9
	public List<Campamento> traerCampamentosPorDias(int mayorIgualA){
		List<Campamento> listAux=new ArrayList<Campamento>();
		for(Servicio s: lstServicios) {
			if (s instanceof Campamento) {
				Campamento campamento=(Campamento) s;
				if(campamento.cantidadDias()>=mayorIgualA) {
					listAux.add(campamento);
;				}
			}
		}
		return listAux;
	}
	
}
