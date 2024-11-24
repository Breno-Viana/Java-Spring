package br.com.apirest.ApiRestAPP.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.ApiRestAPP.Models.Product;
import br.com.apirest.ApiRestAPP.Repositories.ProductRespository;
import br.com.apirest.ApiRestAPP.Utils.ResponseDrops;

@RestController
@RequestMapping("/products")
public class ProductController {
    /*
     * exibir coleção de produtos
     * consultar produtos
     * cadastrar produtos
     * editar produto
     * executar produto
     */

    @Autowired // cria uma instancia da classe ProductRepository sempre que a mesma for usada;
    private ProductRespository productRespository;

    // exibir coleção de produtos
    @GetMapping("/Listar")
    public List<Product> ListProduct() {
        return productRespository.findAll();
    }

    // obter algo pelo id
    @GetMapping("/Obter/{id}")
    public ResponseEntity<Object> GetProduct(@PathVariable Integer id) {
        Optional<Product> product = productRespository.findById(id);

        return !product.isPresent() ? ResponseDrops.GenerateMensages("Produto não encontrado", HttpStatus.NOT_FOUND)
                : new ResponseEntity<Object>(product.get(), HttpStatus.OK);

    }

    // adicionar produto
    @PostMapping
    public ResponseEntity<Object> AddProduct(@RequestBody Product product) {

        if (product.getName() == null || product.getPrice() == null) {
            return ResponseDrops.GenerateMensages("ERROR: Nome ou preço nao inseridos", HttpStatus.BAD_REQUEST);
        }

        Product newProduct = productRespository.save(product);

        return new ResponseEntity<Object>(newProduct, HttpStatus.CREATED);
    }

}
