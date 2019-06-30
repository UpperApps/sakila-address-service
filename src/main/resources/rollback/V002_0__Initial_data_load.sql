DELETE FROM sakila_address.country;
DELETE FROM sakila_address.city;
DELETE FROM sakila_address.address;

DELETE FROM sakila_address.flyway_schema_history WHERE version = '002.0';