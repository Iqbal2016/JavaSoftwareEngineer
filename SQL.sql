------------------------------------Question No: 1.1 -----------------------------------
-------------------------------------Used DB:PostgresSQL--------------------------------
-------------------------------------Create Account Table ------------------------------

CREATE TABLE Account
(
    id bigint NOT NULL,
    name character varying(100),
    address character varying(255),
    account_number character varying(16),
    balance double precision DEFAULT 0  NOT NULL,
    status character varying(50),
    PRIMARY KEY (id)
);

-------------------------------------Insert value Account Table ------------------------------
--character varying column 1st digit 0 not not allowed in this query, when select value need to get wit LPAD Ex: LPAD('1241009211439', 15 , '0') 
INSERT INTO Account(id, name, address,  account_number, balance, status) VALUES(1, 'Mohammad', 'Madaripur' , '1241009211439' , 5000, 'Active');
INSERT INTO Account(id, name, address,  account_number, balance, status) VALUES(2, 'Hossain', 'Rampura' , '32341200923487' , 5000, 'Active');
INSERT INTO Account(id, name, address,  account_number, balance, status) VALUES(3, 'Iqbal', 'Dhaka' , '123456789123456' , 5000, 'Active');


-------------------------------------Create Transaction Table ------------------------------

CREATE TABLE Transaction
(
request_id character varying(50) NOT NULL, 
transaction_time timestamp without time zone,
requester character varying(255),
transaction_type character varying(255),
source_account_number character varying(255),
amount double precision DEFAULT 0  NOT NULL,
destination_account_number character varying(255),
note character varying(255)
);
