package br.com.jpa.filtersapi.api.mapper;

import br.com.jpa.filtersapi.api.dto.ResponseItemDTO;
import br.com.jpa.filtersapi.api.dto.ResponsePageableDTO;
import br.com.jpa.filtersapi.api.dto.ResponseSaleDTO;
import br.com.jpa.filtersapi.domain.model.Item;
import br.com.jpa.filtersapi.domain.model.Sale;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class SalesControllerMapper {

    public static ResponsePageableDTO convertToPageableDTO(Page<Sale> salePage) {
        return ResponsePageableDTO.builder()
                .content(convertToResponseSaleDTO(salePage.getContent()))
                .totalElements(salePage.getTotalElements())
                .pageSize(salePage.getSize())
                .firstPage(salePage.isFirst())
                .lastPage(salePage.isLast())
                .page(salePage.getNumber())
                .build();
    }

    public static List<ResponseSaleDTO> convertToResponseSaleDTO(List<Sale> saleList) {

        List<ResponseSaleDTO> saleDTOList = new ArrayList<>();

        for (Sale sale : saleList) {
            saleDTOList.add(ResponseSaleDTO.builder()
                    .saleStatus(sale.getStatus().getStatus())
                    .itemDTOList(convertToResponseItemDTO(sale.getOrder().getListItem()))
                    .orderCode(sale.getOrder().getOrderCode())
                    .saleDate(sale.getSaleDate())
                    .seller(sale.getSeller().getName())
                    .totalValue(sale.getTotalValue())
                    .build());
        }

        return saleDTOList;
    }

    public static List<ResponseItemDTO> convertToResponseItemDTO(List<Item> itemList) {
        List<ResponseItemDTO> responseItemDTOS = new ArrayList<>();

        for (Item item : itemList) {
            responseItemDTOS.add(ResponseItemDTO.builder()
                    .product(item.getProduct())
                    .productValue(item.getProductValue())
                    .build());
        }
        return responseItemDTOS;
    }
}
