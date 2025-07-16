CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE evento (
                       id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       description VARCHAR(250) NOT NULL,
                       date TIMESTAMP NOT NULL
);