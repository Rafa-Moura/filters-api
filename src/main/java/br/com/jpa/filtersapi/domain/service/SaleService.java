package br.com.jpa.filtersapi.domain.service;

import br.com.jpa.filtersapi.api.dto.RequestFiltersDTO;
import br.com.jpa.filtersapi.domain.model.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface SaleService {

    Page<Sale> getSalesByFilter(RequestFiltersDTO requestFiltersDTO, Pageable pageable, Sort sort);

}
