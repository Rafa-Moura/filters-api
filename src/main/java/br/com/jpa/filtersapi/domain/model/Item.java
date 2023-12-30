package br.com.jpa.filtersapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_itens")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "produto")
    private String product;
    @Column(name = "codigo_produto")
    private String productCode;
    @Column(name = "valor_unitario")
    private BigDecimal productValue;
    @ManyToMany(mappedBy = "listItem", fetch = FetchType.LAZY)
    private List<Order> orders;
    @CreationTimestamp
    @Column(name = "data_criacao")
    private LocalDateTime createdAt;
}
