DROP TABLE sakila_address.address;
DROP TABLE sakila_address.city;
DROP TABLE sakila_address.country;

DELETE FROM sakila_address.flyway_schema_history WHERE version = '001.0';