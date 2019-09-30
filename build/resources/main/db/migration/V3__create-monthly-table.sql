--
-- V3: Create Monthly TABLE
--
--
CREATE TABLE Monthly(
  title VARCHAR(50) NOT NULL,
  explanation VARCHAR(200) NOT NULL,
  start_year VARCHAR(100) NOT NULL,
  start_month VARCHAR(100) NOT NULL,
  start_day VARCHAR(100) NOT NULL,
  end_year VARCHAR(100) NOT NULL,
  end_month VARCHAR(100) NOT NULL,
  end_day VARCHAR(100) NOT NULL,
  start_hour VARCHAR(50) NOT NULL,
  start_minute VARCHAR(50) NOT NULL,
  start_sign VARCHAR(50) NOT NULL,
  end_hour VARCHAR(50) NOT NULL,
  end_minute VARCHAR(50) NOT NULL,
  end_sign VARCHAR(50) NOT NULL,
  repeat_month BOOLEAN NOT NULL,
  all_day BOOLEAN NOT NULL
) DEFAULT CHARSET=utf8;