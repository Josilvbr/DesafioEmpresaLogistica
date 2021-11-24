package cl.silvabravo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.silvabravo.model.Producto;
import cl.silvabravo.service.ProductoServicio;
import cl.silvabravo.util.Util;
import cl.silvabravo.vo.ProductoVO;

@Controller
public class ProductoController {

	@Autowired
	private ProductoServicio svc;
	
	@GetMapping({"/","/home"})
	public String home (ModelMap modelMap, @RequestParam(defaultValue = "1") Integer p, @RequestParam ( defaultValue = "6") Integer cantidadRegistro ){
		
		Integer totalPaginas = svc.getPageCount(cantidadRegistro).getValor();
		modelMap.addAttribute("paginas", Util.getArregloPagina(p, totalPaginas));
		modelMap.addAttribute("paginaActual", p);
		modelMap.addAttribute("VO", svc.getPage(p-1, cantidadRegistro));
		
		return "home";
	}
	
	@GetMapping("/editarForm")
	public ModelAndView editarForm (ModelMap modelMap, @RequestParam String idProducto, RedirectAttributes ra) {
		
		ProductoVO respuestaVO = new ProductoVO();
		respuestaVO.setMensaje("No se puede agregar la vista edicion, intente nuevamente");
		try {
			respuestaVO = svc.findById(Integer.parseInt(idProducto));
			modelMap.addAttribute("mensaje", respuestaVO.getMensaje());
			modelMap.addAttribute("VO", respuestaVO.getProductos().get(0));
			
			return new ModelAndView("editar");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		ra.addFlashAttribute("mensaje", respuestaVO.getMensaje());
		respuestaVO = svc.getAllProductos();
		return new ModelAndView("redirect:/home");
	}
	
	
	@PostMapping("/editar")
    public ModelAndView editar(@ModelAttribute Producto producto, RedirectAttributes ra) {
        ProductoVO respuestaVO = svc.edit(producto);
        ra.addFlashAttribute("mensaje", respuestaVO.getMensaje());
        if (respuestaVO.getCodigo().equals("0")) {
            return new ModelAndView("redirect:/home");
        } else {
            return new ModelAndView("redirect:/editarForm");
        }
    }
	
	
	@GetMapping("/agregarForm")
	public String agregarForm (ModelMap modelMap) {
		return "agregar";
	}
	
	
	@PostMapping ("/agregar")
	public ModelAndView agregar (@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaVO = svc.add(producto);
		ra.addFlashAttribute("mensaje", respuestaVO.getMensaje());
	     if (respuestaVO.getCodigo().equals("0")) {
	            return new ModelAndView("redirect:/home");
	        } else {
	            return new ModelAndView("redirect:/agregarForm");
	        }
	}
	
	@GetMapping("/eliminar")
	public ModelAndView eliminar(ModelMap modelMap, @RequestParam Integer idProducto , RedirectAttributes ra) {
		ProductoVO respuestaVO = new ProductoVO();
		respuestaVO.setMensaje("Nose pudo eliminar el usuario, intente nuevamente");
		try {
			
			Producto productoEliminado = new Producto();
			productoEliminado.setIdProducto(idProducto);
			respuestaVO=svc.delete(productoEliminado);
			ra.addFlashAttribute("mensaje", respuestaVO.getMensaje());
			return new ModelAndView("redirect:/home");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ra.addFlashAttribute("mensaje", respuestaVO.getMensaje());
		respuestaVO = svc.getAllProductos();
		ra.addAttribute("VO", respuestaVO);
		return new ModelAndView("redirect:/home");
		
	}
	
}
