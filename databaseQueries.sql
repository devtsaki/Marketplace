CREATE TABLE category (
	id int(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(45),
	description VARCHAR(255),
	image_url VARCHAR(45),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category (name, description, image_url, is_active) VALUES ('Mobile', 'This is a mobile category', 'CAT_3.png', true );