CREATE TABLE t_inventory 
(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sku_code` VARCHAR(255) NOT NULL,
    `quantity` INT(11) NOT NULL
);