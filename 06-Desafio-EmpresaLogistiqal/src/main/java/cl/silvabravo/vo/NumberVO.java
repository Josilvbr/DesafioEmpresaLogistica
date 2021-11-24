package cl.silvabravo.vo;

public class NumberVO extends GenericVO{

	public int valor;

	public NumberVO(int valor, String mensaje, String codigo) {
		super();
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
	
	
}
