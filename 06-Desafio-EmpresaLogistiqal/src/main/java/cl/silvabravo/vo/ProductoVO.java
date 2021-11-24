package cl.silvabravo.vo;

import java.util.List;

import cl.silvabravo.model.Producto;

public class ProductoVO extends GenericVO{

List<Producto> productos;

public ProductoVO() {
	// TODO Auto-generated constructor stub
}

public ProductoVO(List<Producto> productos, String mensaje, String codigo) {
	super();
	this.productos = productos;
}

public List<Producto> getProductos() {
	return productos;
}

public void setProductos(List<Producto> productos) {
	this.productos = productos;
}


	
	
}
