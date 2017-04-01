DROP TABLE IF EXISTS checkin;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS timestmp;


CREATE TABLE user(
  id varchar(255),
  name varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE timestmp(
  day DATE,
  hour TIME,
  PRIMARY KEY (day, hour)
);

CREATE TABLE checkin(
  id varchar(255),
  day DATE,
  hour TIME,
  PRIMARY KEY(id, day, hour),
  FOREIGN KEY (id) REFERENCES user (id),
  FOREIGN KEY (day, hour) REFERENCES timestmp (day, hour)
);
