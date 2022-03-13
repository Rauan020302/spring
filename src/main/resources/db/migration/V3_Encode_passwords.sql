create extension if not exists pgcrypto;

update usr set password = crypto(password, gen_salt("bf",8));