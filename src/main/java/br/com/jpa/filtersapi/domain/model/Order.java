package br.com.jpa.filtersapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_pedidos")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo_pedido")
    private String orderCode;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_itens_pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> listItem;
    @Column(name = "data_criacao")
    private LocalDateTime createdAt;
}
