INSERT INTO kind(kind_name)VALUES('財布');
INSERT INTO kind(kind_name)VALUES('銀行');
INSERT INTO kind(kind_name)VALUES('クレジット');
INSERT INTO type(type_name)VALUES('食料品');
INSERT INTO type(type_name)VALUES('消耗品');
INSERT INTO type(type_name)VALUES('パソコン');
INSERT INTO type(type_name)VALUES('その他');

INSERT INTO log(value, kind_id, type_id, date, time)VALUES(1500,1,1,'2021-11-30','12:30:10');

INSERT INTO log(value, kind_id, type_id, date, time)VALUES(-500,2,4,'2022-1-1','0:34:00');

INSERT INTO log(value, kind_id, type_id, date, time)VALUES(100,3,2,'2022-2-1','13:22:05');
