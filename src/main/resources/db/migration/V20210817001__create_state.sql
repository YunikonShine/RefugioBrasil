CREATE TABLE state (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    creation_date datetime DEFAULT NOW(),
    update_date datetime DEFAULT NOW(),
    active bit(1) DEFAULT 1,
    initials varchar(2) DEFAULT NULL,
    name varchar(20) DEFAULT NULL,
    PRIMARY KEY (id)
);
