INSERT INTO devices (device_id, name, unit, type, description) VALUES (1, 'thermometer 1', 'celsius', 'temperature', 'inside');
INSERT INTO devices (device_id, name, unit, type, description) VALUES (2, 'thermometer 2', 'fahrenheit', 'temperature', 'outside');
INSERT INTO devices (device_id, name, unit, type, description) VALUES (3, 'light sensor 1', 'unknown', 'lighting', 'inside');
INSERT INTO devices (device_id, name, unit, type, description) VALUES (4, 'light sensor 2', 'unknown', 'lighting', 'outside');
INSERT INTO devices (device_id, name, unit, type, description) VALUES (5, 'humidity sensor', 'percentage', 'humidity', null);
INSERT INTO devices (device_id, name, unit, type, description) VALUES (6, 'motion sensor', 'yyyy-MM-dd HH:mm:ss', 'motion', 'detection');
INSERT INTO devices (device_id, name, unit, type, description) VALUES (7, 'gps', 'lat,long', 'motion', 'analysis');
INSERT INTO devices (device_id, name, unit, type, description) VALUES (8, 'distance sensor', 'centimeter', 'distance', 'to object in front of');
INSERT INTO devices (device_id, name, unit, type, description) VALUES (9, 'magnetometer', 'degree', 'azimuth', null);

INSERT INTO temperature_measurements (measurement_id, device_id, timestamp, measurement) VALUES (1, 1, '2018-05-07 14:52:30', 21.5);

INSERT INTO lighting_measurements (measurement_id, device_id, timestamp, measurement) VALUES (1, 2, '2018-05-07 14:55:30', 500);

INSERT INTO humidity_measurements (measurement_id, device_id, timestamp, measurement) VALUES (1, 5, '2018-05-07 15:00:30', 40);

INSERT INTO detection_measurements (measurement_id, device_id, timestamp) VALUES (1, 6, '2018-05-07 15:05:30');

INSERT INTO gps_measurements (measurement_id, device_id, timestamp, latitude, longitude) VALUES (1, 7, '2018-05-07 15:14:30', 51.759445, 19.457216);

INSERT INTO distance_measurements (measurement_id, device_id, timestamp, measurement) VALUES (1, 8, '2018-05-07 15:20:30', 250);

INSERT INTO magnetic_measurements (measurement_id, device_id, timestamp, measurement) VALUES (1, 9, '2018-05-07 15:29:30', 150);