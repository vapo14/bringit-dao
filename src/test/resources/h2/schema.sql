CREATE SCHEMA IF NOT EXISTS BRING_IT AUTHORIZATION SA;

DROP TABLE users IF EXISTS CASCADE;

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


DROP TABLE bringit_core_list IF EXISTS CASCADE;

CREATE TABLE bringit_core_list (
   id BIGINT GENERATED BY DEFAULT AS IDENTITY,
   owner INT NULL,
   list_title VARCHAR(255) NULL,
   participants INT NULL,
   event_ts DATE NOT NULL,
   CONSTRAINT pk_bringit_core_list PRIMARY KEY (id)
);

ALTER TABLE bringit_core_list ADD CONSTRAINT FK_BRINGIT_CORE_LIST_ON_OWNER FOREIGN KEY (owner) REFERENCES users (id);
ALTER TABLE bringit_core_list ADD CONSTRAINT FK_BRINGIT_CORE_LIST_ON_PARTICIPANTS FOREIGN KEY (participants)
    REFERENCES participant_reg (id);

DROP TABLE participant_reg IF EXISTS CASCADE;

CREATE TABLE participant_reg (
  id INT NOT NULL,
   list BIGINT NULL,
   participant INT NULL,
   CONSTRAINT pk_participant_reg PRIMARY KEY (id)
);

ALTER TABLE participant_reg ADD CONSTRAINT FK_PARTICIPANT_REG_ON_LIST FOREIGN KEY (list) REFERENCES bringit_core_list (id);
ALTER TABLE participant_reg ADD CONSTRAINT FK_PARTICIPANT_REG_ON_PARTICIPANT FOREIGN KEY (participant) REFERENCES users (id);

DROP TABLE items IF EXISTS CASCADE;

CREATE TABLE items (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    item_count VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    assignee VARCHAR(255) NOT NULL,
    list_id BIGINT NOT NULL
);

