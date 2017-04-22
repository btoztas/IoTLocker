DROP TABLE IF EXISTS checkin;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS mobile;
DROP TABLE IF EXISTS alert;

CREATE TABLE user(
  id varchar(255),
  name varchar(255),
  regday DATE,
  reghour TIME,
  PRIMARY KEY (id)
);

CREATE TABLE checkin(
  id varchar(255),
  day DATE,
  hour TIME,
  PRIMARY KEY(id, day, hour),
  FOREIGN KEY (id) REFERENCES user (id)
);

CREATE TABLE alert(
  id INTEGER,
  day DATE,
  hour TIME,
  description varchar(255),
  PRIMARY KEY (id, day, hour)
);

CREATE TABLE mobile (
  token varchar(255),
  regday DATE,
  reghour TIME,
  PRIMARY KEY (Token)
);
