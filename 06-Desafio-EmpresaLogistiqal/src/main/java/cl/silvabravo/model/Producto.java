package cl.silvabravo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; //JPA


@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String codigoUnico;
	private String nombreProducto;
	private String precioProducto;
	private Integer stockProducto;
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}


	public Producto(Integer idProducto, String codigoUnico, String nombreProducto, String precioProducto,
			Integer stockProducto) {
		super();
		this.idProducto = idProducto;
		this.codigoUnico = codigoUnico;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.stockProducto = stockProducto;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	public String getCodigoUnico() {
		return codigoUnico;
	}


	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public String getPrecioProducto() {
		return precioProducto;
	}


	public void setPrecioProducto(String precioProducto) {
		this.precioProducto = precioProducto;
	}


	public Integer getStockProducto() {
		return stockProducto;
	}


	public void setStockProducto(Integer stockProducto) {
		this.stockProducto = stockProducto;
	}
	
	
}
