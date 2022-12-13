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
        beer_id int
        CONSTRAINT pk_user_beer primary key (user_id, beer_id),
        CONSTRAINT fk_user_beer_user foreign key (user_id) references users(user_id),
        CONSTRAINT fk_user_beer_beer foreign key (beer_id) references beers(beer_id)
commit;
----------------------working template above this line---------------------------------



