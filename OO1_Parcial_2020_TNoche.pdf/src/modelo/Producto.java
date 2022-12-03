package modelo;

public class Producto extends Mercancia {
	private String producto;
	private double precioProducto;
	private double porcentajeDescuento;
	private boolean esDescuentoEn2daUnidad;
	
	public Producto(String codMercancia, String producto, double precioProducto, double porcentajeDescuento,
			boolean esDescuentoEn2daUnidad) throws Exception {
		super(codMercancia);
		this.producto = producto;
		this.precioProducto = precioProducto;
		this.porcentajeDescuento = porcentajeDescuento;
		this.esDescuentoEn2daUnidad = esDescuentoEn2daUnidad;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public double getporcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setporcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public boolean isEsDescuentoEn2daUnidad() {
		return esDescuentoEn2daUnidad;
	}

	public void setEsDescuentoEn2daUnidad(boolean esDescuentoEn2daUnidad) {
		this.esDescuentoEn2daUnidad = esDescuentoEn2daUnidad;
	}

	@Override
	public String toString() {
		return super.toString()+"Producto [producto=" + producto + ", precioProducto=" + precioProducto + ", porcentajeDescuento="
				+ porcentajeDescuento + ", esDescuentoEn2daUnidad=" + esDescuentoEn2daUnidad + "]";
	}

	//*********************
	@Override
	public double calcularPrecioFinal() {
		double descuento= precioProducto*(porcentajeDescuento/100);
		if (esDescuentoEn2daUnidad) descuento = descuento/2;
		return precioProducto-descuento;
	}
	
}
