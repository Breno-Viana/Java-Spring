package br.com.apirest.ApiRestAPP.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.ApiRestAPP.Models.Product;;

public interface ProductRespository extends JpaRepository<Product,Integer> {
    
}
