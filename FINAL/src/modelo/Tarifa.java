package modelo;

public class Tarifa {
	private int id;
	private int consumoDesde;
	private int consumoHasta;
	private double cargoFijo;
	private double cargoVariable;
	public Tarifa(int id, int consumoDesde, int consumoHasta, double cargoFijo, double cargoVariable) {
		super();
		this.id = id;
		this.consumoDesde = consumoDesde;
		this.consumoHasta = consumoHasta;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConsumoDesde() {
		return consumoDesde;
	}
	public void setConsumoDesde(int consumoDesde) {
		this.consumoDesde = consumoDesde;
	}
	public int getConsumoHasta() {
		return consumoHasta;
	}
	public void setConsumoHasta(int consumoHasta) {
		this.consumoHasta = consumoHasta;
	}
	public double getCargoFijo() {
		return cargoFijo;
	}
	public void setCargoFijo(double cargoFijo) {
		this.cargoFijo = cargoFijo;
	}
	public double getCargoVariable() {
		return cargoVariable;
	}
	public void setCargoVariable(double cargoVariable) {
		this.cargoVariable = cargoVariable;
	}
	@Override
	public String toString() {
		return "\nTarifa [id=" + id + ", consumoDesde=" + consumoDesde + ", consumoHasta=" + consumoHasta + ", cargoFijo="
				+ cargoFijo + ", cargoVariable=" + cargoVariable + "]";
	}
	
}
