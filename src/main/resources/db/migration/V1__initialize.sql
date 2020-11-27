DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_ID` (`role_id`),
  CONSTRAINT `FK_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FK_USER_ID_01` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` VALUES (1,'admin','$2a$10$4p6U8Ve1ZjJ/S0Qd9RFyB.hJjpusgdYmTtIIqpHs3k0hfbhDe6cyq','Admin','Admin','admin@gmail.com'),(2,'alex','$2a$10$4p6U8Ve1ZjJ/S0Qd9RFyB.hJjpusgdYmTtIIqpHs3k0hfbhDe6cyq','alex','alex','alex@gmail.com'),(3,'nik','$2a$10$4p6U8Ve1ZjJ/S0Qd9RFyB.hJjpusgdYmTtIIqpHs3k0hfbhDe6cyq','nik','nik','nik@gmail.com');
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,1),(1,2),(2,2);
INSERT INTO `clients` VALUES (1,'admin','$2a$10$4p6U8Ve1ZjJ/S0Qd9RFyB.hJjpusgdYmTtIIqpHs3k0hfbhDe6cyq','Admin','Admin','admin@gmail.com'),(2,'alex','$2a$10$4p6U8Ve1ZjJ/S0Qd9RFyB.hJjpusgdYmTtIIqpHs3k0hfbhDe6cyq','alex','alex','alex@gmail.com'),(3,'nik','$2a$10$4p6U8Ve1ZjJ/S0Qd9RFyB.hJjpusgdYmTtIIqpHs3k0hfbhDe6cyq','nik','nik','nik@gmail.com');


