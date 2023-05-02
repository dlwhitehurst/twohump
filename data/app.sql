CREATE DATABASE IF NOT EXISTS `twohump`;

USE `twohump`;

UNLOCK TABLES;

-- ##########################################################################################################
-- CONTACTS
-- ##########################################################################################################

DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
                             `id`                   bigint(19) unsigned NOT NULL AUTO_INCREMENT,
                             `ct_name`              varchar(40) NOT NULL,
                             `ct_email`             varchar(80) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `contacts` WRITE;
INSERT INTO `contacts` (
    ct_name,
    ct_email
) VALUES (
             'David L Whitehurst',
             'me@dlwhitehurst.com'
         );
UNLOCK TABLES;
