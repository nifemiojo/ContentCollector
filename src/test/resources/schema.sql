-- In production DB administrator is responsible for creating table and loading any data

CREATE SEQUENCE IF NOT EXISTS category_id_sequence;

CREATE TABLE IF NOT EXISTS category (

    id BIGINT NOT NULL DEFAULT nextval('category_id_sequence') PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE

);

CREATE SEQUENCE IF NOT EXISTS user_accounts_seq;

CREATE TABLE IF NOT EXISTS user_accounts (

    user_id BIGINT NOT NULL DEFAULT nextval('user_accounts_seq') PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    enabled BOOLEAN NOT NULL

);

CREATE SEQUENCE IF NOT EXISTS content_id_sequence;

CREATE TABLE IF NOT EXISTS content (

    id BIGINT NOT NULL DEFAULT nextval('content_id_sequence') PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    link VARCHAR(500) NOT NULL,
    category_name VARCHAR(100) REFERENCES category (name) ON DELETE SET NULL,
    user_id BIGINT REFERENCES user_accounts (user_id)

);

CREATE TABLE IF NOT EXISTS user_category (

    username BIGINT REFERENCES user_accounts (username),
    category_name VARCHAR(100) REFERENCES category (name) UNIQUE (user_id, category_name)

);