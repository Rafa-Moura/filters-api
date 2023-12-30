package br.com.jpa.filtersapi.api.controller;

import br.com.jpa.filtersapi.api.dto.RequestFiltersDTO;
import br.com.jpa.filtersapi.api.dto.ResponsePageableDTO;
import br.com.jpa.filtersapi.api.mapper.SalesControllerMapper;
import br.com.jpa.filtersapi.domain.model.Sale;
import br.com.jpa.filtersapi.domain.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/sales")
public class SalesController {

    @Autowired
    private SaleService saleService;

    @GetMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePageableDTO> findByFilters(@ModelAttribute RequestFiltersDTO requestFiltersDTO,
                                                             @PageableDefault(size = 25)Pageable pageable,
                                                             Sort sort) {

        Page<Sale> salePage = saleService.getSalesByFilter(requestFiltersDTO, pageable, sort);

        ResponsePageableDTO responsePageableDTO = SalesControllerMapper.convertToPageableDTO(salePage);

        return new ResponseEntity<>(responsePageableDTO, HttpStatus.OK);
    }
}
