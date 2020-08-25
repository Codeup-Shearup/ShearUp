DROP DATABASE IF EXISTS shearup_db;
CREATE DATABASE IF NOT EXISTS shearup_db;
USE shearup_db;

drop table services;

describe users;
describe services;

# SHOW DATABASES;
# SELECT database();
# SHOW TABLES;
# DESCRIBE images;
CREATE TABLE IF NOT EXISTS  images (
                                       id INT UNSIGNED NOT NULL,
                                       filestack_url VARCHAR(255) NOT NULL,
                                       service_id INT UNSIGNED NOT NULL,
                                       PRIMARY KEY (id),
                                       FOREIGN KEY (service_id) REFERENCES images(id)
);
CREATE TABLE IF NOT EXISTS  reviews (
                                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                        title VARCHAR(255) NOT NULL,
                                        content VARCHAR(500) NOT NULL,
                                        rating DECIMAL (2,1),
                                        images_id INT UNSIGNED NOT NULL,
                                        price DECIMAL (4,2),
                                        `appointment_id` INT UNSIGNED NOT NULL,
                                        PRIMARY KEY (id),
                                        FOREIGN KEY (images_id) REFERENCES images(id)

);

CREATE TABLE IF NOT EXISTS locations (
                                         id INT UNSIGNED NOT NULL,
                                         address_one VARCHAR(255) NOT NULL,
                                         address_two VARCHAR(255)  NOT NULL,
                                         city VARCHAR (50) NOT NULL,
                                         state VARCHAR (2) NOT NULL,
                                         zip_code  INT NOT NULL,
                                         PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS barber_details (
                                              id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                              bio LONGTEXT NOT NULL,
                                              images_id INT UNSIGNED NOT NULL,
                                              location_id INT UNSIGNED NOT NULL,
                                              PRIMARY KEY (id),
                                              FOREIGN KEY (images_id) REFERENCES images (id),
                                              FOREIGN KEY (location_id) REFERENCES locations (id)
);
CREATE TABLE IF NOT EXISTS  services (
                                         id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                         title VARCHAR(255) NOT NULL,
                                         description VARCHAR(255) NOT NULL,
                                         price DECIMAL (4,2) NOT NULL,
                                         duration INT DEFAULT NULL,
                                         barber_details_id INT UNSIGNED NOT NULL,
                                         PRIMARY KEY (id),
                                         FOREIGN KEY (barber_details_id) REFERENCES barber_details (id)
);

CREATE TABLE IF NOT EXISTS users (
                    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	                username VARCHAR(255) NOT NULL,
                    first_name VARCHAR(255) NOT NULL,
                    last_name  VARCHAR(255) NOT NULL,
                    email VARCHAR(100) NOT NULL,
                    password VARCHAR(32) NOT NULL,
	                is_barber TINYINT NOT NULL,
                    barber_details_id INT UNSIGNED NOT NULL,
                    PRIMARY KEY (id),
                    UNIQUE KEY(username, email),
                    FOREIGN KEY (barber_details_id) REFERENCES barber_details (id)
);

CREATE TABLE IF NOT EXISTS  appointments (
                    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                    user_id INT UNSIGNED NOT NULL,
                    service_id INT UNSIGNED NOT NULL,
                    appointment_date DATETIME DEFAULT NULL,
		            PRIMARY KEY (id),
                    FOREIGN KEY (user_id) REFERENCES users (id),
                    FOREIGN KEY (service_id) REFERENCES services (id)
);
