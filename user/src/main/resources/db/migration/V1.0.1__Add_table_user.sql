CREATE TABLE `user`
(
    `id`         INT UNSIGNED AUTO_INCREMENT        NOT NULL,
    `name`       VARCHAR(64)                        NOT NULL,
    `age`        INT(3) UNSIGNED                    NOT NULL,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;