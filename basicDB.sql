USE marketplace;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `user_detail` VALUES (1,'123456789','admin@admin.com','','Admin','Admin','$2a$10$Zlkl1tyS4rwUVsKBjlyU1edv6gUjyMhBSU2Nsh6QjxFeuIDFl87u2','ADMIN');


DROP TABLE IF EXISTS `Category`;

CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `Category` VALUES (1,'','Science Fiction',NULL,'Science Fiction'),(2,'','Fantasy',NULL,'Fantasy'),(3,'','Action',NULL,'Action');



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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

INSERT INTO `Product` VALUES (1,'','Star Wars',2,'PRDDF5D278575','Lightsaber from the set of Star Wars 1977','Lightsaber',0,5,1,156,1),(2,'','Ghostbusters',2,'PRDF8FDEDB22E','Ghost Traps used in the filming of the movie Ghostbusters 1984.','Ghost Trap',3,1,1,120.5,0),(3,'','Back to The Future',1,'PRDC4A18EE014','Marty\'s show from the movie.','Marty McFly\'s Shoes',0,2,1,320,0),(4,'','Ghostbusters',2,'PRD5867AD0041','Ghostbuster Uniforms from the set.','Ghotbuster Uniform',0,6,1,54.3,0),(5,'','Back to the Future',1,'PRD914F333129','Ultra rare hoverboard from the movie.','Hoverboard',0,1,1,443,0),(6,'','Captain America',3,'PRDB61E892979','Shield used in the movie Captain America','Shield',0,5,1,60.8,0),(7,'','Thor',2,'PRD04A197D15E','Thor\'s Hammer from the movie.','Hammer',0,7,1,44.9,0),(8,'','Fifth Element',3,'PRDB6AB89219E','Lilu\'s Multipass','Multipass',0,8,1,19,0),(9,'','Indiana Jones',3,'PRD818B64591E','Dr Indiana Jones Diary','Diary',0,3,1,110,0),(10,'','Indiana Jones',3,'PRD54C133F037','Ark of the Covenant from the movie Indiana Jones','Ark of the Covenant',1,2,1,500,1),(11,'','Indiana Jones',3,'PRD156D47D66B','The Fertility Idol from the movie Indiana Jones','The Fertility Idol',0,3,1,78,0);

DROP TABLE IF EXISTS `BankAccount`;

CREATE TABLE `BankAccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgkcmf0cbnc2prlo8g653s5h5e` (`user_id`),
  CONSTRAINT `FKgkcmf0cbnc2prlo8g653s5h5e` FOREIGN KEY (`user_id`) REFERENCES `user_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `BankAccount` VALUES (1,1000000,1);
