INSERT INTO units (unit_id, description) VALUES (1, 'K');
INSERT INTO units (unit_id, description) VALUES (2, 'C');

INSERT INTO measurement_types (measurement_type_id, description, additional_information) VALUES (1, 'temperature', 'outside');
INSERT INTO measurement_types (measurement_type_id, description, additional_information) VALUES (2, 'temperature', 'inside');

INSERT INTO devices (device_id, custom_id, measurement_type_id, unit_id) VALUES (1, 'thermometer_1', 1, 1);
INSERT INTO devices (device_id, custom_id, measurement_type_id, unit_id) VALUES (2, 'thermometer_2', 2, 2);

INSERT INTO temperature_measurements (measurement_id, device_id, measurement) VALUES (1, 1, 298.15)