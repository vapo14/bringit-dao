select * from users;
delete from users where id = '9eb6fd3f-4bba-4e57-9e52-c81f67e11c01';

drop table users;


CREATE TABLE users (
   id INT NOT NULL AUTO_INCREMENT,
   username VARCHAR(255) NULL,
   email VARCHAR(255) NULL,
   password VARCHAR(255) NULL,
   password_salt VARCHAR(255) NULL,
   CONSTRAINT pk_users PRIMARY KEY (id),
   CONSTRAINT username_users UNIQUE (username),
   CONSTRAINT email_users UNIQUE (email)
);

drop table bringit_core_list;

CREATE TABLE bringit_core_list (
  id BIGINT NOT NULL auto_increment,
   owner VARCHAR(255) NULL,
   list_title VARCHAR(255) NULL,
   participants VARCHAR(255) NULL,
   event_ts DATE NOT NULL,
   item_count INT NOT NULL,
   public_id VARCHAR(255) NOT NULL,
   CONSTRAINT pk_bringit_core_list PRIMARY KEY (id)
);

CREATE INDEX idx_list_publicId ON bringit_core_list (public_id);

select * from bringit_core_list;



CREATE TABLE participant_reg (
  id INT NOT NULL,
   list BIGINT NULL,
   participant INT NULL,
   CONSTRAINT pk_participant_reg PRIMARY KEY (id)
);


CREATE TABLE items (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    quantity VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    assignee VARCHAR(255) NOT NULL,
    list_id BIGINT NOT NULL
);