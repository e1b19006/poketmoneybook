INSERT INTO kind(user_id,kind_name)VALUES(00001,'財布');
INSERT INTO kind(user_id,kind_name)VALUES(00001,'銀行');
INSERT INTO kind(user_id,kind_name)VALUES(00002,'財布');
INSERT INTO kind(user_id,kind_name)VALUES(00002,'銀行');
INSERT INTO kind(user_id,kind_name)VALUES(00002,'クレジット');
INSERT INTO kind(user_id,kind_name)VALUES(00003,'財布');
INSERT INTO kind(user_id,kind_name)VALUES(00003,'銀行');
INSERT INTO kind(user_id,kind_name)VALUES(00003,'icoca');
INSERT INTO type(user_id,type_name)VALUES(00001,'食料品');
INSERT INTO type(user_id,type_name)VALUES(00001,'消耗品');
INSERT INTO type(user_id,type_name)VALUES(00001,'パソコン');
INSERT INTO type(user_id,type_name)VALUES(00002,'食料品');
INSERT INTO type(user_id,type_name)VALUES(00002,'消耗品');
INSERT INTO type(user_id,type_name)VALUES(00002,'車');
INSERT INTO type(user_id,type_name)VALUES(00002,'その他');
INSERT INTO type(user_id,type_name)VALUES(00003,'食料品');
INSERT INTO type(user_id,type_name)VALUES(00003,'消耗品');
INSERT INTO type(user_id,type_name)VALUES(00003,'ゴルフ');
INSERT INTO type(user_id,type_name)VALUES(00003,'その他');
INSERT INTO user(user_name)VALUES('user1');
INSERT INTO user(user_name)VALUES('user2');
INSERT INTO user(user_name)VALUES('user3');

INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(1650,1,1,1,'2022-1-1','11:40:00', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(1540,1,1,3,'2022-1-5','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(98,1,1,1,'2022-1-13','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(484,1,1,2,'2022-1-14','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(64590,1,2,1,'2022-1-15','12:30:10', 1);

INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(1200,2,1,1,'2022-1-1','11:40:00', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(990,2,2,2,'2022-1-5','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(98,2,1,1,'2022-1-13','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(100400,2,3,3,'2022-1-14','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(256870,2,2,1,'2022-1-15','12:30:10', 1);

INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(1200  ,3,1,1,'2022-1-1','11:40:00', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(9440   ,3,2,2,'2022-1-5','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(781    ,3,1,1,'2022-1-13','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(12300,3,3,3,'2022-1-14','12:30:10', 0);
INSERT INTO log(value, user_id, kind_id, type_id, date, time, status)VALUES(145300,3,2,1,'2022-1-15','12:30:10', 1);
