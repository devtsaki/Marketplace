DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_number` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user_detail` VALUES (1,'123456789','admin@admin.com','','Admin','Admin','$2a$10$Zlkl1tyS4rwUVsKBjlyU1edv6gUjyMhBSU2Nsh6QjxFeuIDFl87u2','ADMIN');

LOCK TABLES `user_detail` WRITE;
UNLOCK TABLES;
DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_line_one` varchar(255) NOT NULL,
  `billing` bit(1) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `postal_code` varchar(255) NOT NULL,
  `shipping` bit(1) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh0aaa6l9ggi7ixnfoljp3yqmw` (`user_id`),
  CONSTRAINT `FKh0aaa6l9ggi7ixnfoljp3yqmw` FOREIGN KEY (`user_id`) REFERENCES `user_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Address` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `BankAccount`;

CREATE TABLE `BankAccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgkcmf0cbnc2prlo8g653s5h5e` (`user_id`),
  CONSTRAINT `FKgkcmf0cbnc2prlo8g653s5h5e` FOREIGN KEY (`user_id`) REFERENCES `user_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `BankAccount` VALUES (1,1000000,1);

LOCK TABLES `BankAccount` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `Cart`;
CREATE TABLE `Cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_lines` int(11) DEFAULT NULL,
  `grand_total` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiycdwkfx8m2ht0vaitrj8hd0h` (`user_id`),
  CONSTRAINT `FKiycdwkfx8m2ht0vaitrj8hd0h` FOREIGN KEY (`user_id`) REFERENCES `user_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `Cart` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Category` VALUES (1,'','Science Fiction',NULL,'Science Fiction'),(2,'','Fantasy',NULL,'Fantasy'),(3,'','Action',NULL,'Action');

LOCK TABLES `Category` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `brand` varchar(255) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `purchases` int(11) DEFAULT '0',
  `quantity` int(11) NOT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `views` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Product` VALUES (1,'','Star Wars',2,'PRDDF5D278575','Lightsaber from the set of Star Wars 1977','Lightsaber',0,5,1,156,1),(2,'','Ghostbusters',2,'PRDF8FDEDB22E','Ghost Traps used in the filming of the movie Ghostbusters 1984.','Ghost Trap',3,1,1,120.5,0),(3,'','Back to The Future',1,'PRDC4A18EE014','Marty\'s show from the movie.','Marty McFly\'s Shoes',0,2,1,320,0),(4,'','Ghostbusters',2,'PRD5867AD0041','Ghostbuster Uniforms from the set.','Ghotbuster Uniform',0,6,1,54.3,0),(5,'','Back to the Future',1,'PRD914F333129','Ultra rare hoverboard from the movie.','Hoverboard',0,1,1,443,0),(6,'','Captain America',3,'PRDB61E892979','Shield used in the movie Captain America','Shield',0,5,1,60.8,0),(7,'','Thor',2,'PRD04A197D15E','Thor\'s Hammer from the movie.','Hammer',0,7,1,44.9,0),(8,'','Fifth Element',3,'PRDB6AB89219E','Lilu\'s Multipass','Multipass',0,8,1,19,0),(9,'','Indiana Jones',3,'PRD818B64591E','Dr Indiana Jones Diary','Diary',0,3,1,110,0),(10,'','Indiana Jones',3,'PRD54C133F037','Ark of the Covenant from the movie Indiana Jones','Ark of the Covenant',1,2,1,500,1),(11,'','Indiana Jones',3,'PRD156D47D66B','The Fertility Idol from the movie Indiana Jones','The Fertility Idol',0,3,1,78,0);

LOCK TABLES `Product` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `Stock`;
CREATE TABLE `Stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `brand` varchar(255) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit_price` double DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Stock` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `Wishlist`;
CREATE TABLE `Wishlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_available` bit(1) DEFAULT NULL,
  `wishlist_lines` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcxopovkc0unhwofnjvcr7vj7s` (`user_id`),
  CONSTRAINT `FKcxopovkc0unhwofnjvcr7vj7s` FOREIGN KEY (`user_id`) REFERENCES `user_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Wishlist` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `cart_line`;
CREATE TABLE `cart_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_available` bit(1) DEFAULT NULL,
  `buying_price` double DEFAULT NULL,
  `cart_id` int(11) DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL,
  `total` double NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKid6jgprm3g219xpamigbwk97j` (`product_id`),
  CONSTRAINT `FKid6jgprm3g219xpamigbwk97j` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `cart_line` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_count` int(11) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_total` double DEFAULT NULL,
  `billing_id` int(11) DEFAULT NULL,
  `shipping_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq2sjpfmpwttmn4dfb3satda6t` (`billing_id`),
  KEY `FKkke4g52v9adm8d34helwpa9je` (`shipping_id`),
  KEY `FKi3ak21dvyd99avohifylcrtij` (`user_id`),
  CONSTRAINT `FKi3ak21dvyd99avohifylcrtij` FOREIGN KEY (`user_id`) REFERENCES `user_detail` (`id`),
  CONSTRAINT `FKkke4g52v9adm8d34helwpa9je` FOREIGN KEY (`shipping_id`) REFERENCES `Address` (`id`),
  CONSTRAINT `FKq2sjpfmpwttmn4dfb3satda6t` FOREIGN KEY (`billing_id`) REFERENCES `Address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `order_detail` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buying_price` double DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL,
  `total` double NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtgnxy2ydiugl25vsye22npaxe` (`order_id`),
  KEY `FK6xyequv6tp9t8c10gi3cxnql1` (`product_id`),
  CONSTRAINT `FK6xyequv6tp9t8c10gi3cxnql1` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`),
  CONSTRAINT `FKtgnxy2ydiugl25vsye22npaxe` FOREIGN KEY (`order_id`) REFERENCES `order_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `order_item` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `wishlist_line`;
CREATE TABLE `wishlist_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_available` tinyint(1) DEFAULT '1',
  `buying_price` double DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL,
  `total` double NOT NULL,
  `wishlist_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsw7vkcetauv1tmutn3l32f88v` (`product_id`),
  CONSTRAINT `FKsw7vkcetauv1tmutn3l32f88v` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `wishlist_line` WRITE;
UNLOCK TABLES;
