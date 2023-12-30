package br.com.jpa.filtersapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePageableDTO {

    private List<?> content;
    private int page;
    private int pageSize;
    private long totalElements;
    private boolean firstPage;
    private boolean lastPage;
}
