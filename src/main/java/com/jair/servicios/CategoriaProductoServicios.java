package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.CategoriaProducto;
import com.jair.repositorios.categoriaProductoRepository;

@Service
public class CategoriaProductoServicios {

	@Autowired
	private categoriaProductoRepository categoriaRepository;
	
	public void CrearCategoria(CategoriaProducto categoria) {
		categoriaRepository.save(categoria);
	}
	
	public void ActualizarCategoria(CategoriaProducto categoria) {
		categoriaRepository.save(categoria);
	}
	
	public void EliminarCategoria(Long IdCategoriaProdcuto) {
		categoriaRepository.deleteById(IdCategoriaProdcuto);
	}
	
	public CategoriaProducto BuscarCategoria(Long IdCategoriaProdcuto) {
		return categoriaRepository.findById(IdCategoriaProdcuto).get();
	}
	
	public List<CategoriaProducto> ListarCategoria(){
		return categoriaRepository.findAll();
	}
	
}
