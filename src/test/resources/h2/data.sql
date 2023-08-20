INSERT INTO USERS (id, username, email, password, password_salt) VALUES
('1234', 'vapo', 'vapo@mail.com', 'test123.', 'dkfjslkdjf');

INSERT INTO USERS (id, username, email, password, password_salt) VALUES
('3333', 'other user', 'other@mail.com', 'test123.', 'dkfjslkdjf');


INSERT INTO BRINGIT_CORE_LIST (id, owner, list_title, participants) VALUES
('1234', '1234', 'My list', '37298');

INSERT INTO PARTICIPANT_REG (id, list, participant) VALUES
('37298', '1234', '3333');