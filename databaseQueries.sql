CREATE TABLE category (
	id int(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(45),
	description VARCHAR(255),
	image_URL VARCHAR(45),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);