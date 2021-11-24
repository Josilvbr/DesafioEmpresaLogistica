package cl.silvabravo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.silvabravo.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>, PagingAndSortingRepository <Producto,Integer>  {

//Dos opciones de consulta de Query
	
	@Query(value="SELECT * FROM Producto WHERE nombre_producto like %?1%", nativeQuery = true)
//	@Query("FROM Producto WHERE nombre_Producto LIKE %?1%") //el % indica buscar la palabra hacia adelante o detras. En medio de una frase; el N°1 en % ?1 % significa la cantidad de parametros a entregar
	public List<Producto> findByNombre (String nombre);
	
	
}
