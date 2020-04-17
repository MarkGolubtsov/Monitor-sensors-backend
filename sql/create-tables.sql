CREATE TABLE `range`
(
    `id`   int PRIMARY KEY,
    `from` int default 0,
    `to`   int default 1
);

CREATE TABLE `type`
(
    `id`   int PRIMARY KEY,
    `name` varchar(300) NOT NULL
);

CREATE TABLE `unit`
(
    `id`   int PRIMARY KEY,
    `name` varchar(200) NOT NULL
);

CREATE TABLE `monitor_sensors`
(
    `id`          int PRIMARY KEY AUTO_INCREMENT,
    `name`        varchar(100) NOT NULL,
    `model`       varchar(100) NOT NULL,
    `range_id`    int,
    `type_id`     int,
    `unit_id`     int,
    `location`    varchar(200) NOT NULL,
    `description` varchar(500) default '',
    FOREIGN KEY (range_id) REFERENCES `range` (id),
    FOREIGN KEY (type_id) REFERENCES `type` (id),
    FOREIGN KEY (unit_id) REFERENCES unit (id)
);