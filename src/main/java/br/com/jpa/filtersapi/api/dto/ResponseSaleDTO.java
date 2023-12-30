package br.com.jpa.filtersapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSaleDTO {

    private String seller;
    private String orderCode;
    private List<ResponseItemDTO> itemDTOList;
    private BigDecimal totalValue;
    private String saleStatus;
    private LocalDateTime saleDate;


}
