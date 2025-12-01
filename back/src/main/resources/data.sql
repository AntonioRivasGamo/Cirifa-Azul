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
       );;
       
       
INSERT INTO public.animal (age,can_fly,can_speak,is_castrated,is_vaccinated,weight,created_at,updated_at,id,user_id,"type",breed,diet,gender,hair_length,more_details,name,"size",species,water_type,main_photo) VALUES
	 (13,NULL,NULL,true,true,22.3,'2025-12-01 19:08:11.752953','2025-12-01 19:08:11.752995','f68a8843-032d-4621-9d55-d72df13679c6'::uuid,'b1ffcd88-8d0a-3fe7-aa5c-5aa8ac270b22'::uuid,'DOG','Labrador',NULL,'MALE','LONG',NULL,'Juanito','MEDIUM',NULL,NULL,NULL),
	 (3,NULL,NULL,false,false,2.3,'2025-12-01 19:09:37.430733','2025-12-01 19:09:37.430756','7f5ccb79-fca2-4d1b-aedf-973488644106'::uuid,'b1ffcd88-8d0a-3fe7-aa5c-5aa8ac270b22'::uuid,'CAT','Gato',NULL,'FEMALE','HAIRLESS',NULL,'Calvo','TOY',NULL,NULL,NULL);
