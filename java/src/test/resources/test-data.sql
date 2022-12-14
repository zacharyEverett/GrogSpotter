BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS breweries (
	brewery_id serial,
	brewery_name varchar(40) not null unique,
	street_address varchar(100) not null,
	city varchar(50) not null,
	state_abv varchar(2) not null,
	zip varchar(10) not null,
	time_open time not null,
	time_closed time not null,
	history varchar(1000) not null,
	is_active boolean not null default true,
	brewer_id int not null,

	CONSTRAINT pk_breweries PRIMARY KEY (brewery_id)

);

CREATE TABLE IF NOT EXISTS beers (
	beer_id serial,
	brewery_id int not null,
	beer_name varchar(50) not null unique,
	abv decimal not null,
	beer_type varchar(50) not null,
	beer_description varchar (500) not null,

	CONSTRAINT pk_beers PRIMARY KEY (beer_id),
	CONSTRAINT fk_beer_brewery FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
);


CREATE TABLE IF NOT EXISTS reviews (
	review_id serial,
	username varchar not null,
	title varchar(100) not null,
	beer_id int,
	brewery_id int,
	rating int not null,
	review_body varchar(1000) not null,

	CONSTRAINT pk_reviews PRIMARY KEY (review_id),
	CONSTRAINT fk_review_user FOREIGN KEY (username) REFERENCES users(username),
	CONSTRAINT fk_review_beer FOREIGN KEY (beer_id) REFERENCES beers(beer_id),
	CONSTRAINT fk_review_brewery FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)

);

CREATE TABLE IF NOT EXISTS user_beers (
        user_id int,
        beer_id int,
        CONSTRAINT pk_user_beer primary key (user_id, beer_id),
        CONSTRAINT fk_user_beer_user foreign key (user_id) references users(user_id),
        CONSTRAINT fk_user_beer_beer foreign key (beer_id) references beers(beer_id)
);


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

insert into breweries (brewery_name, street_address, city, state_abv, zip, time_open, time_closed, history, brewer_id)
values ('Mindful', '3759 Library Rd', 'Pittsburgh', 'PA', '15234', '11:00', '0:00', 'Mindful brewery is a new hot spot in the Castle Shannon borough of Pittsburgh, crafting their own beers. They also have a renowned menu of pub food with a restaurant open to all ages', 2);
insert into beers (brewery_id, beer_name, abv, beer_type, beer_description)
values ((select brewery_id from breweries where brewery_name = 'Mindful'), '88 rabbits', 8, 'Adjunct Lager', 'Named for the famous route 88 that Mindful resides on' );
insert into breweries (brewery_name, street_address, city, state_abv, zip, time_open, time_closed, history, brewer_id)
values ('Kyle Beer Co', '111 Beer Lane', 'Beertown', 'PA', '15228', '0:00', '0:00', 'The south hills premier location for locally crafted beers', 1);


insert into beers (brewery_id, beer_name, abv, beer_type, beer_description)
values
((select brewery_id from breweries where brewery_name = 'Kyle Beer Co'), 'Kyles Blonde Lager', '12.1', 'American Lager', 'Flagship beer from the flagship brewery in Western PA'),
((select brewery_id from breweries where brewery_name = 'Kyle Beer Co'), 'TomA Porter', '12.5', 'Porter', 'Dark and strong porter created by the infamous Tom Anderson');
select * from reviews;

insert into reviews (username, title, beer_id, rating, review_body)
values
((select username from users where username = 'user'), 'DRINK THIS ONE!', (select beer_id from beers where beer_name = '88 rabbits'), 5, 'It is the greatest beer in all the VERLD!'),
((select username from users where username = 'user'), 'Refreshing', (select beer_id from beers where beer_name = 'Kyles Blonde Lager'), 4, 'Slimy, yet satisfying!'),
((select username from users where username = 'admin'), 'One of my new favorites!', (select beer_id from beers where beer_name = '88 rabbits'), 5, '5 out of 5!'),
((select username from users where username = 'admin'), 'Just OK for me dawg', (select beer_id from beers where beer_name = 'TomA Porter'), 4, 'Better than OK, not great');
insert into reviews (username, title, brewery_id, rating, review_body)
values
((select username from users where username = 'user'), 'Great food, great beer', (select brewery_id from breweries where brewery_name = 'Mindful'), 5, 'Great establishment!'),
((select username from users where username = 'user'), 'Beer lovers come here', (select brewery_id from breweries where brewery_name = 'Kyle Beer Co'), 4, 'Great beer, food just OK'),
((select username from users where username = 'admin'), 'Get the TomA Porter!', (select brewery_id from breweries where brewery_name = 'Mindful'), 5, 'Great selection of beer, not just all IPAs like some places');

COMMIT;