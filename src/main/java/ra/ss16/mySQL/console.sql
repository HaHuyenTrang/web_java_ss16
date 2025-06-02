create database ss16;
use ss16;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       role VARCHAR(10) NOT NULL,
                       status BOOLEAN DEFAULT TRUE
);

-- Tạo bảng trip
CREATE TABLE trip (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      departure VARCHAR(100) NOT NULL,
                      destination VARCHAR(100) NOT NULL,
                      time VARCHAR(100)
);
