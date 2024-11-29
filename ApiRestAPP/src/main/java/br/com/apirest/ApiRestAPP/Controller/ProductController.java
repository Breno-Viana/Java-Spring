package br.com.apirest.ApiRestAPP.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.apirest.ApiRestAPP.Models.Product;
import br.com.apirest.ApiRestAPP.Repositories.ProductRespository;
import br.com.apirest.ApiRestAPP.Utils.ResponseDrops;
import jakarta.validation.Valid;

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
    @GetMapping("/listar")
    public List<Product> ListProduct() {
        return productRespository.findAll();
    }

    // obter algo pelo id
    @GetMapping("/obter/{id}")
    public ResponseEntity<Object> GetProduct(@PathVariable Integer id) {
        Optional<Product> product = productRespository.findById(id);

        return !product.isPresent() ? ResponseDrops.GenerateMessages("Produto não encontrado", HttpStatus.NOT_FOUND)
                : new ResponseEntity<Object>(product.get(), HttpStatus.OK);

    }

    // adicionar produto
    @PostMapping("/postar")
    public ResponseEntity<Object> AddProduct(@RequestBody @Valid Product product) {

        Product newProduct = productRespository.save(product);

        return new ResponseEntity<Object>(newProduct, HttpStatus.CREATED);
    }

    // editar produto
    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> EditUpdate(@PathVariable Integer id, @RequestBody @Valid Product product) {

        Optional<Product> OldProduct = productRespository.findById(id);

        if (!OldProduct.isPresent()) {
            return ResponseDrops.GenerateMessages("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
       
        Product ProductUptdate = OldProduct.get();
        ProductUptdate.setName(product.getName());
        ProductUptdate.setPrice(product.getPrice());
        ProductUptdate.setDescription(product.getDescription());

        productRespository.save(ProductUptdate);
        return ResponseDrops.GenerateMessages("Produto Alterado Com Sucesso", HttpStatus.CREATED);

    }


    @DeleteMapping("/del/{id}")
    public ResponseEntity<Object> DeleteProduct(@PathVariable Integer id){

        Optional<Product> OldProduct = productRespository.findById(id);
        if (!OldProduct.isPresent()) {
            return ResponseDrops.GenerateMessages("Produto nao encontrado", HttpStatus.NOT_FOUND);
        }

        Product product = OldProduct.get();
        productRespository.delete(OldProduct.get());
        return ResponseDrops.GenerateMessages("Produto "+product.getName()+" deletado", HttpStatus.ACCEPTED);
        

    }

    @PutMapping("/edit/desc/{id}")
    public ResponseEntity<Object> EditDescription(@PathVariable Integer id, @RequestBody Product product){
        Optional<Product> OldProduct = productRespository.findById(id);
        if (!OldProduct.isPresent()) {
            return ResponseDrops.GenerateMessages("Produto não encontrado", HttpStatus.BAD_REQUEST);
        }

      
        
        Product product2 = OldProduct.get();
        product2.setDescription(product.getDescription());
        productRespository.save(product2);
        return ResponseDrops.GenerateMessages("Descrição do "+OldProduct.get().getName()+" alterada", HttpStatus.ACCEPTED);

    }
}
