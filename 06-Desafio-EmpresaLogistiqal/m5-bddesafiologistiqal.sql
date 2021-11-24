CREATE TABLE producto (
id_producto INT AUTO_INCREMENT PRIMARY KEY, 
codigo_unico VARCHAR(255),
nombre_producto VARCHAR(255),
precio_producto VARCHAR(255),
stock_producto INT

);

CREATE TABLE hibernate_sequence (
id INT
);



INSERT INTO producto VALUES(NULL, "001", "Limon", "$400",  10); 
INSERT INTO producto VALUES(NULL, "002", "Manzana", "$600",  5); 
INSERT INTO producto VALUES(NULL, "003", "Naranja", "$800",  7); 
INSERT INTO producto VALUES(NULL, "004", "Pera", "$400",  5); 
INSERT INTO producto VALUES(NULL, "005", "Platanos", "$990",  3);
INSERT INTO producto VALUES(NULL, "006", "Kiwi", "$800",  5); 
INSERT INTO producto VALUES(NULL, "006", "Durazno", "$890",  5);  

SELECT * FROM producto;