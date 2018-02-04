CREATE TABLE category (
  id int(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(45),
	description VARCHAR(255),
	image_url VARCHAR(45),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id)

);

CREATE TABLE user_detail (
  id INT(11) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(45),
	last_name VARCHAR(45),
	role VARCHAR(45),
	enabled BOOLEAN,
	password VARCHAR(45),
	email VARCHAR(45),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY (id)
);


CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT,
	code VARCHAR(20),
	name VARCHAR(45),
	brand VARCHAR(45),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id)
);	

-- the address table to store the user billing and shipping addresses
CREATE TABLE address (
	id int(11) NOT NULL AUTO_INCREMENT,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(25),
	country VARCHAR(25),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);

-- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id int(11) NOT NULL AUTO_INCREMENT,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);

-- adding three categories
INSERT INTO category (name, description,image_url,is_active) 
VALUES ('Laptop', 'This is description for Laptop category!', 'CAT_1.png', true),
		('Television', 'This is description for Television category!', 'CAT_2.png', true),
		('Mobile', 'This is description for Mobile category!', 'CAT_3.png', true);
		
-- adding three users 
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number)
VALUES  ('George', 'Tsakiris', 'ADMIN', true, 'admin', 'tsaki67@gmail.com', '123456789'),
		('John', 'Tade', 'SUPPLIER', true, '1234', 'john@gmail.com', '321456789'),
		('Maria', 'Poula', 'SUPPLIER', true, '1234', 'maria@gmail.com', '777456789');
		
-- adding a supplier correspondece address
INSERT INTO address( user_id, address_line_one, address_line_two, city, country, postal_code, is_billing, is_shipping) 
VALUES (2, '55 Seferi St, Faros', 'Near Ote', 'Athens', 'Greece', '12123', true, false );

-- adding a cart for testing 
INSERT INTO cart (user_id, grand_total, cart_lines) VALUES (null, 0, 0);

-- adding five products
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('ABCD1234DEF', 'iphone 8', 'Apple', 'This is the iphone 8', 750, 10, true, 3, 2),
	   ('CDEF3334GEF', 'iphone 7s', 'Apple', 'This is the iphone 7s', 600.4, 7, true, 3, 2),
	   ('ARPD1994PPF', 'KU6400', 'Samsung', 'This is the Samsung KU6400 smart TV', 650, 6, true, 2, 3),
	   ('OEYT3694VPQ', 'Macbook Pro', 'Apple', 'This is the Macbook pro', 1650, 5, true, 1, 3),
	   ('NMGS5314VPD', 'XPS-13', 'Dell', 'This is the Dell XPS 13', 1250, 5, true, 1, 3);
