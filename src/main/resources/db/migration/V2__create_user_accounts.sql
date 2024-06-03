CREATE TABLE users (
  username varchar(50) NOT NULL,
  password char(68) NOT NULL,
  enabled tinyint NOT NULL,
  PRIMARY KEY (username)
);

INSERT INTO users
VALUES
('elena','{bcrypt}$2a$10$n0ppWi8C5wBQ30PXhg5Oquk5YaeU0k19u5u3rQhd5veK6wB6lYO16',1),
('marijus','{bcrypt}$2a$10$n0ppWi8C5wBQ30PXhg5Oquk5YaeU0k19u5u3rQhd5veK6wB6lYO16',1);

CREATE TABLE authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (username,authority),
  CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO `authorities`
VALUES
('elena','ROLE_USER'),
('marijus','ROLE_USER'),
('marijus','ROLE_ADMIN')