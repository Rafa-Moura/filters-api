package br.com.jpa.filtersapi.domain.repository;

import br.com.jpa.filtersapi.domain.model.SaleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleStatusRepository extends JpaRepository<SaleStatus, Long> {
}
