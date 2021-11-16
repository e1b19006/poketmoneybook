CREATE TABLE kind(
  kind_id IDENTITY PRIMARY KEY,
  kind_name CHAR NOT NULL
);

CREATE TABLE type(
  type_id IDENTITY PRIMARY KEY,
  type_name CHAR NOT NULL
);


CREATE TABLE log(
  log_id IDENTITY PRIMARY KEY,
  value INT NOT NULL,
  kind_id INT NOT NULL ,
  type_id INT NOT NULL ,
  date DATE,
  time TIME,
  constraint key1 FOREIGN KEY (kind_id) references kind(kind_id),
  constraint key2 FOREIGN KEY (type_id) references type(type_id)
);
