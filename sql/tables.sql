DROP TABLE IF EXISTS checkin;
DROP TABLE IF EXISTS user;


CREATE TABLE user(
  id varchar(255),
  name varchar(255),
  PRIMARY KEY (id)
);


CREATE TABLE checkin(
  id varchar(255),
  day DATE,
  hour TIME,
  PRIMARY KEY(id, day, hour),
  FOREIGN KEY (id) REFERENCES user (id)
);
