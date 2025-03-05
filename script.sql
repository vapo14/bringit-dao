drop table if exists users;


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

drop table if exists bringit_core_list;

CREATE TABLE bringit_core_list (
  id BIGINT NOT NULL auto_increment,
   owner VARCHAR(255) NULL,
   list_title VARCHAR(255) NULL,
   participants VARCHAR(255) NULL,
   event_ts DATE NOT NULL,
   item_count INT NOT NULL,
   CONSTRAINT pk_bringit_core_list PRIMARY KEY (id)
);

drop table if exists participant_reg;

CREATE TABLE participant_reg (
  id INT NOT NULL,
   list BIGINT NULL references bringit_core_list (id),
   participant INT NULL references users (id),
   CONSTRAINT pk_participant_reg PRIMARY KEY (id)
);

drop table if exists items;

CREATE TABLE items (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    quantity VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    assignee VARCHAR(255) NOT NULL,
    list_id BIGINT NOT NULL,
    CONSTRAINT pk_items PRIMARY KEY (id)
);

DROP TABLE IF EXISTS contacts;

CREATE TABLE contacts (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL references users (id),
    contact_id BIGINT NOT NULL references users (id),
    CONSTRAINT pk_contacts PRIMARY KEY (id)
);
