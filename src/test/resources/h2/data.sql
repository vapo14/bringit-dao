INSERT INTO USERS (id, username, email, password, password_salt) VALUES
('1234', 'vapo', 'vapo@mail.com', 'test123.', 'dkfjslkdjf');

INSERT INTO USERS (id, username, email, password, password_salt) VALUES
('3333', 'other user', 'other@mail.com', 'test123.', 'dkfjslkdjf');

INSERT INTO USERS (id, username, email, password, password_salt) VALUES
('1000001', 'createUserTest', 'test-email122@mail.com', 'test123.', 'dkfjslkdjf');

INSERT INTO BRINGIT_CORE_LIST (id, owner, list_title, event_ts, item_count) VALUES
('1234', '1234', 'My list', '2024-06-10', 0);
INSERT INTO BRINGIT_CORE_LIST (id, owner, list_title, event_ts, item_count) VALUES
('12345', '1234', 'My list', '2024-06-10', 0);

INSERT INTO PARTICIPANT_REG (id, list, participant) VALUES
('37298', '1234', '3333');

INSERT INTO ITEMS (id, name, description, quantity, image, assignee, list_id) VALUES
('28767', 'Napkins', 'small package', '2', '/some/image/path', '3333', '1234');