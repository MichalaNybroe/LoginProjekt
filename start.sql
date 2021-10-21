USE littlebirdie;
CREATE TABLE `users` (
                         `user_id` int NOT NULL AUTO_INCREMENT,
                         `user_name` varchar(45) NOT NULL,
                         `user_password` varchar(45) NOT NULL,
                         PRIMARY KEY (`user_id`)
);

INSERT INTO users(user_name, user_password) VALUES ('test', 'test');