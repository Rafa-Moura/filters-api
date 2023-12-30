package br.com.jpa.filtersapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_status_venda")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleStatus {

    @Id
    private Long id;
    private String status;
    @Column(name = "descricao_status")
    private String statusDescription;
    @Column(name = "data_criacao")
    private LocalDateTime createdAt;

}
