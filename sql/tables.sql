DROP TABLE IF EXISTS check_in;
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

CREATE TABLE check_in(
  id varchar(255),
  day DATE,
  hour TIME,
  PRIMARY KEY(day, hour, id),
  FOREIGN KEY (id) REFERENCES user (id),
  FOREIGN KEY (day) REFERENCES timestmp (day),
  FOREIGN KEY (hour) REFERENCES timestmp (hour)
);
