--liquibase formatted sql

--changeset k.abylay:1

CREATE TABLE IF NOT EXISTS brands
(
    ID BIGSERIAL PRIMARY KEY ,
    NAME VARCHAR NOT NULL ,
    CODE VARCHAR NOT NULL UNIQUE
);

--changeset d.dhazaksylyk:2
ALTER TABLE IF EXISTS brands
ADD COLUMN DESCRIPTION TEXT

--changeset n.nazerke:3
;CREATE TABLE IF NOT EXISTS items
 (
     ID BIGSERIAL PRIMARY KEY ,
     NAME VARCHAR ,
     PRICE DOUBLE PRECISION,
     BRAND_ID BIGSERIAL,
     FOREIGN KEY (BRAND_ID)
        REFERENCES brands(ID)
 )