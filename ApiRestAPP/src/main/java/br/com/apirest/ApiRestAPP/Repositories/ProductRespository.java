package br.com.apirest.ApiRestAPP.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apirest.ApiRestAPP.Models.Product;;

@Repository
public interface ProductRespository extends JpaRepository<Product,Integer> {
    
}
