package br.com.jpa.filtersapi.domain.service.impl;

import br.com.jpa.filtersapi.api.dto.RequestFiltersDTO;
import br.com.jpa.filtersapi.domain.model.Sale;
import br.com.jpa.filtersapi.domain.repository.SaleRepository;
import br.com.jpa.filtersapi.domain.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Page<Sale> getSalesByFilter(RequestFiltersDTO requestFiltersDTO, Pageable pageable, Sort sort) {

        return saleRepository.findByFilters(requestFiltersDTO, pageable, sort);
    }
}
