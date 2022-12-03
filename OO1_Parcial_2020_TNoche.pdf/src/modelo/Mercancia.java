package modelo;

public abstract class Mercancia {
	private String codMercancia;

	public Mercancia(String codMercancia) throws Exception {
		super();
//		this.codMercancia = codMercancia;
		this.setCodMercancia(codMercancia); //si tiene 7 digitos es valida
	}

	public String getCodMercancia() {
		return codMercancia;
	}

	public void setCodMercancia(String codMercancia) throws Exception {
		if (!esValido(codMercancia)) throw new Exception("El codigo no es valido");
		this.codMercancia = codMercancia;
	}

	@Override
	public String toString() {
		return "Mercancia [codMercancia=" + codMercancia + "]";
	}
	//***************
	
	public boolean esValido(String codMercancia) {
		return codMercancia.length()==7;
	}
	public abstract double calcularPrecioFinal();
	
}
