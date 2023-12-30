package br.com.jpa.filtersapi.domain.repository;

import br.com.jpa.filtersapi.domain.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>, CustomSaleRepository{
}
