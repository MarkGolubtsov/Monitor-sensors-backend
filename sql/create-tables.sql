CREATE TABLE `types`
(
    `id`   int PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(300) NOT NULL
);

CREATE TABLE `units`
(
    `id`   int PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(200) NOT NULL
);

CREATE TABLE `monitor_sensors`
(
    `id`          int PRIMARY KEY AUTO_INCREMENT,
    `name`        varchar(100) NOT NULL,
    `model`       varchar(100) NOT NULL,
    `range_from`        int          default 0,
    `range_to`          int          default 1,
    `type_id`     int,
    `unit_id`     int,
    `location`    varchar(200) NOT NULL,
    `description` varchar(500) default '',
    FOREIGN KEY (type_id) REFERENCES `types` (id),
    FOREIGN KEY (unit_id) REFERENCES units (id)
);

CREATE TABLE `users`
(
    `id`       int PRIMARY KEY AUTO_INCREMENT,
    email      varchar(200) UNIQUE NOT NULL,
    `password` varchar(100),
    `roles`    varchar(100)
);