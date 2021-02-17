-- In production DB administrator is responsible for creating table and loading any data

CREATE SEQUENCE IF NOT EXISTS category_id_sequence;

CREATE TABLE IF NOT EXISTS category (

    id BIGINT NOT NULL DEFAULT nextval('category_id_sequence') PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE

    );

CREATE SEQUENCE IF NOT EXISTS content_id_sequence;

CREATE TABLE IF NOT EXISTS content (

    id BIGINT NOT NULL DEFAULT nextval('content_id_sequence') PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    link VARCHAR(500) NOT NULL,
    category_name VARCHAR(100) REFERENCES category (name) ON DELETE SET NULL

    );