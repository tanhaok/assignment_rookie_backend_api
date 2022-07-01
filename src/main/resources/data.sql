INSERT INTO role (id, role) VALUES (1, 'ROLE_ADMIN'),(2, 'ROLE_USER');

-- INSERT INTO users(id, email, name, username, password) VALUES 
-- (1,'admin@rookies.com', 'Admin', 'admin' , '$2a$10$EBbAdMQnazZ/WNJ0VJZZROIXfm3Rz9yUttvmecSEWHX7YOMKGaa7a'),
-- (2,'user@rookies.com', 'User', 'user' , '$2a$10$EBbAdMQnazZ/WNJ0VJZZROIXfm3Rz9yUttvmecSEWHX7YOMKGaa7a');

INSERT INTO user_roles(acc_id, role_id) VALUES (1,1), (2,2);



