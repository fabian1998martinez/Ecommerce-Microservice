-- Primero las categorías
INSERT INTO tbl_categories (id, name) VALUES (1, 'shoes');
INSERT INTO tbl_categories (id, name) VALUES (2, 'books');
INSERT INTO tbl_categories (id, name) VALUES (3, 'electronics');

-- Luego los productos
INSERT INTO tbl_products (name, description, stock, price, status, create_at, category_id)
VALUES (
  'adidas Cloudfoam Ultimate',
  'Walk in the air in the black / black CLOUDFOAM ULTIMATE running shoe from ADIDAS',
  5, 178.89, 'CREATED', '2018-09-05', 1
);

-- ⚠️ Aquí estaba el problema: las comillas dentro de la descripción
INSERT INTO tbl_products (name, description, stock, price, status, create_at, category_id)
VALUES (
  'under armour Men''s Micro G Assert – 7',
  'under armour Men''s Lightweight mesh upper delivers complete breathability. Durable leather overlays for stability',
  4, 12.5, 'CREATED', '2018-09-05', 1
);

INSERT INTO tbl_products (name, description, stock, price, status, create_at, category_id)
VALUES (
  'Spring Boot in Action',
  'Craig Walls is a software developer at Pivotal and is the author of Spring in Action',
  12, 40.06, 'CREATED', '2018-09-05', 2
);
