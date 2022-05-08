/*******************************************************************************
   Video_library
   Script: video_library_MySql.sql
   DB Server: MySql
   Author: Taras Kozodoi
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP DATABASE IF EXISTS `video_library`;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE DATABASE `video_library`;


USE `video_library`;


/*******************************************************************************
   Create Tables
********************************************************************************/

CREATE TABLE `actor`
(
	actor_id serial not null,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    birdsyear year not null
);

CREATE TABLE `film`
(
	film_id serial not null,
    title varchar(255) not null,
    release_year year not null,
    release_country text not null
);

CREATE TABLE `film_actor`
(
	film_id int not null,
    actor_id int not null
);

CREATE TABLE `film_producer`
(
	film_id int not null,
    actor_id int not null
);

/*******************************************************************************
   Insert data
********************************************************************************/

INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (1, 'Iron Man', '2008', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (2, 'Thor', '2010', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (3, 'The Avengers', '2012', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (4, 'Ant-Man', '2015', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (5, 'Doctor Strange', '2016', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (6, 'Thor: Ragnarok', '2017', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (7, 'Capitan Marvel', '2018', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (8, 'Black Widow', '2021', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (9, 'Eternals', '2021', 'USA');
INSERT INTO `film` (film_id, title, release_year, release_country) VALUES (10, 'Speder-Man: No Way Home', '2021', 'USA');

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (1, 'Jon', 'Favreau', 1966);
INSERT INTO `film_producer` (film_id, actor_id) values (1, 1);
INSERT INTO `film_actor` (film_id, actor_id) values (1, 1);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (2, 'Robert', 'Downey', 1965);
INSERT INTO `film_actor` (film_id, actor_id) values (1, 2);
INSERT INTO `film_actor` (film_id, actor_id) values (3, 2);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (3, 'Chris', 'Hemsworth', 1983);
INSERT INTO `film_actor` (film_id, actor_id) values (2, 3);
INSERT INTO `film_actor` (film_id, actor_id) values (3, 3);
INSERT INTO `film_actor` (film_id, actor_id) values (6, 3);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (4, 'Peyton', 'Reed', 1964);
INSERT INTO `film_producer` (film_id, actor_id) values (4, 4);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (5, 'Paul', 'Rudd', 1969);
INSERT INTO `film_actor` (film_id, actor_id) values (4, 5);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (6, 'Benedict', 'Cumberbatch', 1976);
INSERT INTO `film_actor` (film_id, actor_id) values (5, 6);
INSERT INTO `film_actor` (film_id, actor_id) values (10, 6);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (7, 'Brianne', 'Desaulniers', 1989);
INSERT INTO `film_actor` (film_id, actor_id) values (7, 7);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (8, 'Samuel', 'Jackson', 1948);
INSERT INTO `film_actor` (film_id, actor_id) values (3, 8);
INSERT INTO `film_actor` (film_id, actor_id) values (7, 8);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (9, 'Ryan', 'Dleck', 1976);
INSERT INTO `film_producer` (film_id, actor_id) values (7, 9);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (10, 'Scarlett', 'Johansson', 1984);
INSERT INTO `film_actor` (film_id, actor_id) values (3, 10);
INSERT INTO `film_actor` (film_id, actor_id) values (8, 10);

INSERT INTO `actor` (actor_id, first_name, last_name, birdsyear) values (11, 'Harry', 'Styles', 1994);
INSERT INTO `film_actor` (film_id, actor_id) values (9, 11);
