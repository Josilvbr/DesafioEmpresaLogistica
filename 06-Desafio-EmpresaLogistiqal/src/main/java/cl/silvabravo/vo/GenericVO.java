package cl.silvabravo.vo;


public class GenericVO {

	public String mensaje;
	public String codigo;
	
	public GenericVO() {
		// TODO Auto-generated constructor stub
	}

	public GenericVO(String mensaje, String codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
