package br.com.jpa.filtersapi.domain.repository;

import br.com.jpa.filtersapi.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
