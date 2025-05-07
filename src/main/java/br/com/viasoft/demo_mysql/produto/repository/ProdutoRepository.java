package br.com.viasoft.demo_mysql.produto.repository;

import br.com.viasoft.demo_mysql.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}