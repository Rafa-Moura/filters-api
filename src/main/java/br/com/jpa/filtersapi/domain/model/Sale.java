package br.com.jpa.filtersapi.domain.model;

import jakarta.persistence.*;
import jakarta.validation.Constraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_vendas")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vendedor", referencedColumnName = "id")
    private Seller seller;
    @OneToOne
    @JoinColumn(name = "pedido", referencedColumnName = "id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id")
    private SaleStatus status;
    @Column(name = "valor_total")
    private BigDecimal totalValue;
    @CreationTimestamp
    @Column(name = "data_venda")
    private LocalDateTime saleDate;
}
