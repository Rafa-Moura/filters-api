package br.com.jpa.filtersapi.domain.repository.impl;

import br.com.jpa.filtersapi.api.dto.RequestFiltersDTO;
import br.com.jpa.filtersapi.domain.model.Order;
import br.com.jpa.filtersapi.domain.model.*;
import br.com.jpa.filtersapi.domain.repository.CustomSaleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SaleRepositoryImpl implements CustomSaleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Sale> findByFilters(RequestFiltersDTO requestFiltersDTO, Pageable pageable, Sort sort) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Sale> query = builder.createQuery(Sale.class);

        Root<Sale> root = query.from(Sale.class);

        Join<Sale, SaleStatus> statusJoin = root.join("status", JoinType.INNER);
        Join<Sale, Seller> sellerJoin = root.join("seller", JoinType.INNER);
        Join<Sale, Order> orderJoin = root.join("order", JoinType.INNER);
        Join<Order, Item> itemJoin = orderJoin.join("listItem", JoinType.INNER);


        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasLength(requestFiltersDTO.getSellersName())) {
            predicates.add(builder.like(sellerJoin.get("name"), "%" + requestFiltersDTO.getSellersName() + "%"));
        }

        if(StringUtils.hasLength(requestFiltersDTO.getProduct())){
            predicates.add(builder.like(itemJoin.get("product"), "%" + requestFiltersDTO.getProduct() + "%"));
        }

        if (StringUtils.hasLength(requestFiltersDTO.getSaleStatus())) {
            predicates.add(builder.equal(statusJoin.get("status"), requestFiltersDTO.getSaleStatus()));
        }

        if (StringUtils.hasLength(requestFiltersDTO.getOrderCode())) {
            predicates.add(builder.equal(orderJoin.get("orderCode"), requestFiltersDTO.getOrderCode()));
        }

        if (sort != null) {
            List<jakarta.persistence.criteria.Order> orders = new ArrayList<>();
            for (Sort.Order order : sort) {
                if (order.isAscending()) {
                    orders.add(builder.asc(root.get(order.getProperty())));
                } else {
                    orders.add(builder.desc(root.get(order.getProperty())));
                }
            }
            query.orderBy(orders);
        }

        query.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Sale> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        List<Sale> resultList = typedQuery.getResultList();

        return new PageImpl<>(resultList, pageable, resultList.size());
    }
}
