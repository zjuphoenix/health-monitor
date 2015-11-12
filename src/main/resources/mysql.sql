USE artificial_liver;
CREATE TABLE user(
  id INT(4) not null primary key auto_increment,
  username VARCHAR(40) not null,
  gender VARCHAR(2) not null,
  password VARCHAR(40),
  tel VARCHAR(20),
  mail VARCHAR(30)
);
SELECT * FROM users WHERE username = #{username} LIMIT 1;

CREATE TABLE bloodoxygen(
  userId INT COMMENT '用户id',
  timestamp LONG NOT NULL COMMENT '时间戳',
  pulse_rate INT COMMENT '脉率',
  saturation VARCHAR(10) COMMENT '饱和度',
  pulse_intensity INT COMMENT '脉搏强度',
  status BOOL COMMENT '是否异常'
);

CREATE TABLE bloodpressure(
  userId INT COMMENT '用户id',
  timestamp LONG NOT NULL COMMENT '时间戳',
  systolic_pressure INT COMMENT '收缩压',
  diastolic_pressure INT COMMENT '舒张压',
  mean_pressure INT COMMENT '平均压',
  pulse_rate INT COMMENT '脉率',
  status BOOL COMMENT '是否异常'
);

CREATE TABLE ecg(
  userId INT COMMENT '用户id',
  timestamp LONG NOT NULL COMMENT '时间戳',
  breath_rate INT COMMENT '呼吸率',
  heart_rate INT COMMENT '心率',
  status BOOL COMMENT '是否异常'
);

CREATE TABLE bloodsugar(
  userId INT COMMENT '用户id',
  timestamp LONG NOT NULL COMMENT '时间戳',
  blood_sugar INT COMMENT '血糖',
  status BOOL COMMENT '是否异常'
);

CREATE TABLE bloodketone(
  userId INT COMMENT '用户id',
  timestamp LONG NOT NULL COMMENT '时间戳',
  blood_ketone INT COMMENT '血酮',
  status BOOL COMMENT '是否异常'
);



