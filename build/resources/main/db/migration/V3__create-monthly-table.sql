--
-- V3: Create Monthly TABLE
--
--
CREATE TABLE Monthly(
  title VARCHAR(50) NOT NULL,
  explanation VARCHAR(100) NOT NULL,
  start_schedule VARCHAR(100) NOT NULL,
  end_schedule VARCHAR(100) NOT NULL,
  start_time VARCHAR(50) NOT NULL,
  end_time VARCHAR(50) NOT NULL,
  repeat_month BOOLEAN NOT NULL,
  all_day BOOLEAN NOT NULL
) DEFAULT CHARSET=utf8;