--
-- V3: Create Calendar TABLE
--
--

CREATE TABLE Calendar(
  year VARCHAR(50) NOT NULL,
  month VARCHAR(50) NOT NULL,
  day VARCHAR(50) NOT NULL,
  PRIMARY KEY(year,month,day)
) DEFAULT CHARSET=utf8;

