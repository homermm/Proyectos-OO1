package modelo;

public abstract class Cliente {
	protected int id;
	protected long numeroCliente;
	
	public Cliente(int id, long numeroCliente) {
		super();
		this.id = id;
		this.numeroCliente = numeroCliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(long numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	@Override
	public String toString() {
		return "\nCliente [id=" + id + ", numeroCliente=" + numeroCliente + "]";
	}
	
}
