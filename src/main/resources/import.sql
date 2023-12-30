insert into tb_vendedores (nome, data_criacao) values ('Roberto Paulo', CURRENT_TIMESTAMP);
insert into tb_vendedores (nome, data_criacao) values ('Shirley Francisca', CURRENT_TIMESTAMP);
insert into tb_vendedores (nome, data_criacao) values ('Epaminondas Oriovaldo', CURRENT_TIMESTAMP);

insert into tb_itens (produto, codigo_produto, valor_unitario, data_criacao) values ('Ervilhas 200G enlatada','ERV1123', 4.99, CURRENT_TIMESTAMP);
insert into tb_itens (produto, codigo_produto, valor_unitario, data_criacao) values ('Milho verde 200G enlatado','MLH1123', 5.99, CURRENT_TIMESTAMP);
insert into tb_itens (produto, codigo_produto, valor_unitario, data_criacao) values ('Filé de peito de frango 1KG','FRA1123', 14.99, CURRENT_TIMESTAMP);
insert into tb_itens (produto, codigo_produto, valor_unitario, data_criacao) values ('Coxão duro KG','CXD1123', 34.99, CURRENT_TIMESTAMP);
insert into tb_itens (produto, codigo_produto, valor_unitario, data_criacao) values ('Arroz branco 1KG','ARR1123', 6.99, CURRENT_TIMESTAMP);
insert into tb_itens (produto, codigo_produto, valor_unitario, data_criacao) values ('Feijão carioca 1KG','FJC1123', 8.99, CURRENT_TIMESTAMP);

insert into tb_status_venda (id, status, descricao_status, data_criacao) values (1, 'PAGO', 'Indica que a compra foi paga integralmente', CURRENT_TIMESTAMP);

insert into tb_pedidos (codigo_pedido, data_criacao) values ('VENDA251120231', CURRENT_TIMESTAMP);
insert into tb_pedidos (codigo_pedido, data_criacao) values ('VENDA251120232', CURRENT_TIMESTAMP);

insert into tb_itens_pedido (item_id, pedido_id) values (1, 1);
insert into tb_itens_pedido (item_id, pedido_id) values (2, 1);
insert into tb_itens_pedido (item_id, pedido_id) values (3, 1);
insert into tb_itens_pedido (item_id, pedido_id) values (4, 1);
insert into tb_itens_pedido (item_id, pedido_id) values (5, 1);
insert into tb_itens_pedido (item_id, pedido_id) values (6, 1);

insert into tb_itens_pedido (item_id, pedido_id) values (1, 2);
insert into tb_itens_pedido (item_id, pedido_id) values (2, 2);
insert into tb_itens_pedido (item_id, pedido_id) values (3, 2);

insert into tb_vendas (vendedor, pedido, status, valor_total, data_venda) values (1, 1, 1, 76.94, CURRENT_TIMESTAMP);
insert into tb_vendas (vendedor, pedido, status, valor_total, data_venda) values (1, 2, 1, 76.94, CURRENT_TIMESTAMP);
