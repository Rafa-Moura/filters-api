package br.com.jpa.filtersapi.domain.repository;

import br.com.jpa.filtersapi.api.dto.RequestFiltersDTO;
import br.com.jpa.filtersapi.domain.model.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface CustomSaleRepository {

    Page<Sale> findByFilters(RequestFiltersDTO requestFiltersDTO, Pageable pageable, Sort sort);

}
