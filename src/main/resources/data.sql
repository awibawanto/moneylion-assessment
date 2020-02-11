DROP TABLE IF EXISTS feature;

CREATE TABLE feature (
  feature_name VARCHAR(250) PRIMARY KEY,
  email VARCHAR(100) NOT NULL,
  enable BOOLEAN
);

INSERT INTO feature(feature_name, email, enable) VALUES
  ('feature1', 'andika@wibawanto.com', true),
  ('feature2', 'andika@wibawanto.com', true),
  ('feature3', 'andika@wibawanto.com', true);