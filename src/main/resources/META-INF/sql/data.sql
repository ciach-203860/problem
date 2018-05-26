INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (1, 'thermometer 1',   'CELSIUS',     'TEMPERATURE',      'property.temperature.inside');
INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (2, 'thermometer 2',   'FAHRENHEIT',  'TEMPERATURE',      'property.temperature.outside');
INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (3, 'light sensor 1',  'UNKNOWN',     'LIGHTING',         'property.lighting.inside');
INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (4, 'light sensor 2',  'UNKNOWN',     'LIGHTING',         'property.lighting.outside');
INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (5, 'humidity sensor', 'PERCENTAGE',  'HUMIDITY',         'property.humidity');
INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (6, 'motion sensor',   'DATE',        'MOTION_DETECTION', 'property.motion.detection');
INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (7, 'gps',             'COORDINATES', 'MOTION_ANALYSIS',  'property.motion.analysis');
INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (8, 'distance sensor', 'CENTIMETER',  'DISTANCE',         'property.distance.object.opposite');
INSERT INTO devices (device_id, name, unit, measurement_type, description_key) VALUES (9, 'magnetometer',    'DEGREE',      'AZIMUTH',          'property.azimuth');

INSERT INTO temperature_measurements (measurement_id, device_id, timestamp, measurement)         VALUES (1, 1, '2018-05-07 14:52:30', 21.5);
INSERT INTO temperature_measurements (measurement_id, device_id, timestamp, measurement)         VALUES (2, 1, '2018-05-07 15:52:30', 24.5);
INSERT INTO temperature_measurements (measurement_id, device_id, timestamp, measurement)         VALUES (3, 1, '2018-05-07 16:52:30', 20.1);
INSERT INTO temperature_measurements (measurement_id, device_id, timestamp, measurement)         VALUES (4, 2, '2018-05-07 16:52:30', 20.1);


INSERT INTO lighting_measurements    (measurement_id, device_id, timestamp, measurement)         VALUES (1, 3, '2018-05-07 14:55:30', 500);

INSERT INTO humidity_measurements    (measurement_id, device_id, timestamp, measurement)         VALUES (1, 5, '2018-05-07 15:00:30', 40);

INSERT INTO detection_measurements   (measurement_id, device_id, timestamp, measurement)         VALUES (1, 6, '2018-05-07 15:05:30', '2018-05-07 15:05:30');

INSERT INTO gps_measurements         (measurement_id, device_id, timestamp, latitude, longitude) VALUES (1, 7, '2018-05-07 15:14:30', 51.759445, 19.457216);

INSERT INTO distance_measurements    (measurement_id, device_id, timestamp, measurement)         VALUES (1, 8, '2018-05-07 15:20:30', 250);

INSERT INTO magnetic_measurements    (measurement_id, device_id, timestamp, measurement)         VALUES (1, 9, '2018-05-07 15:29:30', 150);