package cl.silvabravo.service;

import cl.silvabravo.model.Producto;
import cl.silvabravo.vo.NumberVO;
import cl.silvabravo.vo.ProductoVO;

public interface ProductoServicio {

	public ProductoVO getAllProductos();

	public ProductoVO findByNombre(String nombre);

	public ProductoVO add(Producto producto);

	public ProductoVO edit(Producto producto);

	public ProductoVO delete(Producto producto);
	public ProductoVO findById(Integer idProducto);

	public ProductoVO getPage(Integer pagina, Integer cantidad); // Int cantidad es la cantidad de elementos a mostrar
																	// por pagina

	public NumberVO getPageCount(int registrosPorPagina);

}
