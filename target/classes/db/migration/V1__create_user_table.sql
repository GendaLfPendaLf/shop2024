CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    sex VARCHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    basket_id BIGINT
);