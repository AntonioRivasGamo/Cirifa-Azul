-- USERS DE PRUEBA PARA LA BD EN MEMORIA, FALTA IMPLEMENTAR HASH DE PASSWORDS
INSERT INTO users (id, email, username, password, role, status, created_at, updated_at)
VALUES (
           'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11',
           'admin@cirifa.com',
           'admin',
           '123456',
           'ADMIN',
           'ACTIVE',
           CURRENT_TIMESTAMP,
           CURRENT_TIMESTAMP
       );

INSERT INTO users (id, email, username, password, role, status, created_at, updated_at)
VALUES (
           'b1ffcd88-8d0a-3fe7-aa5c-5aa8ac270b22',
           'user@cirifa.com',
           'client',
           '123456',
           'CLIENT',
           'ACTIVE',
           CURRENT_TIMESTAMP,
           CURRENT_TIMESTAMP
       );