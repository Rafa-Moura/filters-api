package br.com.jpa.filtersapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FiltersDTO {
    private String sellersName;
    private String saleCode;
    private String product;
    private String orderCode;
    private String saleStatus;
}
