INSERT INTO types (name)
VALUES ('Pressure');
INSERT INTO types (name)
VALUES ('Voltage');
INSERT INTO types (name)
VALUES ('Temperature');
INSERT INTO types (name)
VALUES ('Humidity');


INSERT INTO units (name)
VALUES ('bar');
INSERT INTO units (name)
VALUES ('voltage');
INSERT INTO units (name)
VALUES ('°С');
INSERT INTO units (name)
VALUES ('%');


INSERT INTO monitor_sensors (name, model, range_from, range_to, type_id, unit_id, location, description)
 VALUES ('Sensor_1','PC33-56',0,16,1,1,'Room1','Some input');

INSERT INTO monitor_sensors (name, model, range_from, range_to, type_id, unit_id, location, description)
 VALUES ('Sensor_2','EH-567',-25,25,2,2,'Room1','Some input');

INSERT INTO monitor_sensors (name, model, range_from, range_to, type_id, unit_id, location, description)
VALUES ('Sensor_3','PC33-56',-70,50,3,3,'Room2','Some input');

INSERT INTO monitor_sensors (name, model, range_from, range_to, type_id, unit_id, location, description)
VALUES ('Sensor_4','H94',0,100,4,4,'Room2','Some input');

