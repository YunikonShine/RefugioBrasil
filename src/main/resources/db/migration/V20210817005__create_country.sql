CREATE TABLE country (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    creation_date datetime DEFAULT NOW(),
    update_date datetime DEFAULT NOW(),
    active bit(1) DEFAULT 1,
    name varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);
