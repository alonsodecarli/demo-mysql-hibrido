package br.com.viasoft.demo_mysql.produto.controller;

import br.com.viasoft.demo_mysql.produto.entity.Produto;
import br.com.viasoft.demo_mysql.produto.repository.ProdutoRepository;
import br.com.viasoft.demo_mysql.routing.ReadOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @ReadOnly
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}