-- Contraseñas hasheadas con BCrypt: admin123 y user123

INSERT INTO users (id, email, username, first_name, last_name, password, role, status, created_at, updated_at)
VALUES (
           'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11',
           'admin@cirifa.com',
           'admin',
           'Admin',
           'System',
           '$2a$10$CZiex1t3/XMpoeFnx6t8POwfcY4kMRRqKwGMsYV.xCk2l5hrcHHu.',
           'ADMIN',
           'ACTIVE',
           CURRENT_TIMESTAMP,
           CURRENT_TIMESTAMP
       );

INSERT INTO users (id, email, username, first_name, last_name, password, role, status, created_at, updated_at)
VALUES (
           'b1ffcd88-8d0a-3fe7-aa5c-5aa8ac270b22',
           'user@cirifa.com',
           'client',
           'John',
           'Doe',
           '$2a$10$.20IMOTunlxjVP72gYVUcel6OwVnwX79GksDwDk.07syCt7SL/WLS',
           'CLIENT',
           'ACTIVE',
           CURRENT_TIMESTAMP,
           CURRENT_TIMESTAMP
       );