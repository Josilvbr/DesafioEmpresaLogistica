package cl.silvabravo.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.silvabravo.model.Producto;
import cl.silvabravo.repository.ProductoRepository;
import cl.silvabravo.vo.NumberVO;
import cl.silvabravo.vo.ProductoVO;

@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	ProductoRepository productoRepository;
	ProductoVO respuestaVO;

	@Override
	@Transactional(readOnly = true)
	public ProductoVO getAllProductos() {
		respuestaVO = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "101");
		try {
			respuestaVO.setProductos((List<Producto>) productoRepository.findAll());
			respuestaVO.setMensaje(String.format("Se ha/n encontrado %d registros", respuestaVO.getProductos().size()));
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuestaVO;
	}

	@Override
	public ProductoVO findByNombre(String nombre) {
		respuestaVO = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "102");
		try {
			List<Producto> productos = productoRepository.findByNombre(nombre);
			if (productos.size()>0) {
				respuestaVO.setProductos(productos);
				respuestaVO.setMensaje("Producto encontrado correctamente");
				respuestaVO.setCodigo("0");
				
			} else {
				respuestaVO.setMensaje("Producto no Encontrado");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuestaVO;
	}

	@Override
	@Transactional
	public ProductoVO add(Producto producto) {
		respuestaVO = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "103");
		try {
			productoRepository.save(producto);
			
			respuestaVO.setProductos((List<Producto>) productoRepository.findAll());
			respuestaVO.setMensaje(String.format("Se ha guardado el producto %s.", producto.getNombreProducto()));
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuestaVO;
	}

	@Override
	public ProductoVO edit(Producto producto) {
		respuestaVO = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "104");
		try {
//			ProductoVO productoVO = findById(producto.getIdProducto());
//			if (productoVO.getProductos() !=null) {
//				for (Producto productoTemp : productoVO.getProductos()) {
//					productoTemp.setIdProducto(productoTemp.getIdProducto());
//					productoTemp.setNombreProducto(productoTemp.getNombreProducto());
//					productoTemp.setCodigoUnico(productoTemp.getCodigoUnico());
//					productoTemp.setPrecioProducto(productoTemp.getPrecioProducto());
//					productoTemp.setStockProducto(productoTemp.getStockProducto());
//				}	
//			}
			productoRepository.save(producto);
			respuestaVO.setProductos((List<Producto>) productoRepository.findAll());
			respuestaVO.setMensaje(String.format("Se ha actualizado correctamente el producto %s", producto.getNombreProducto()));
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuestaVO;
	}

	@Override
	public ProductoVO delete(Producto producto) {
		respuestaVO = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "105");
		try {
			productoRepository.delete(producto);
			respuestaVO.setMensaje(String.format("Se ha eliminado el producto %s.", producto.getNombreProducto()));
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuestaVO;
	}

	@Override
	public ProductoVO getPage(Integer pagina, Integer cantidad) {
		System.out.println("Aqui quedo en Get Page");
		respuestaVO = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "106" );
        try {
            Pageable pageable = PageRequest.of(pagina,cantidad);
            Page<Producto> responsePage = productoRepository.findAll(pageable);
            respuestaVO.setProductos(responsePage.getContent());
            respuestaVO.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuestaVO.getProductos().size()));
            respuestaVO.setCodigo("0");
            System.out.println("Aqui logra setear mensaje y codigo de getPage");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuestaVO;
	}

	@Override
	@Transactional (readOnly = true)
	public NumberVO getPageCount(int registrosPorPagina) {
System.out.println("Aqui llega a getPageCount");
		NumberVO respuesta = new NumberVO(0, "Ha ocurrido un error", "108");
	    try {
	    	int registros = (int) productoRepository.count();
	    	if (registrosPorPagina == 0 && registros == 0) {
				respuesta.setValor(1);
			} else {
			respuesta.setValor((registros/registrosPorPagina)+ (registros % registrosPorPagina == 0 ? 0 : 1));
			}
	    	
	    	respuesta.setCodigo("201");
	    	respuesta.setMensaje(String.format("Hay %d paginas", respuesta.getValor()));
	    	System.out.println("aqui logra setear el Mensaje en getPageCount");
         
        } catch (Exception e) {
            e.printStackTrace();
        }
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO findById(Integer idProducto) {
		respuestaVO = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "108");
		try {
			Producto producto = productoRepository.findById(idProducto).get(); 
			respuestaVO.getProductos().add(producto);
			respuestaVO.setProductos((List<Producto>) productoRepository.findAll());
			respuestaVO.setMensaje(String.format("Se ha/n encontrado %d producto ", null != producto ? 1:0));
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuestaVO;
	}

}
