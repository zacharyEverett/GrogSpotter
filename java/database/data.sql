
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


insert into breweries (brewery_name, brewery_address, time_open, time_closed, history)
values ('Mindful', '3759 Library Rd, Pittsburgh, PA 15234', '11:00', '0:00', 'Mindful brewery is a new hot spot in the Castle Shannon borough of Pittsburgh, crafting their own beers. They also have a renowned menu of pub food with a restaurant open to all ages');
insert into beers (brewery_id, beer_name, abv, beer_type, beer_description)
values ((select brewery_id from breweries where brewery_name = 'Mindful'), '88 rabbits', 8, 'Adjunct Lager', 'Named for the famous route 88 that Mindful resides on' );
insert into breweries (brewery_name, brewery_address, time_open, time_closed, history)
values ('Kyle Beer Co', '111 Beer Lane, Beertown, PA 15228', '0:00', '0:00', 'The south hills premier location for locally crafted beers');


insert into beers (brewery_id, beer_name, abv, beer_type, beer_description)
values
((select brewery_id from breweries where brewery_name = 'Kyle Beer Co'), 'Kyles Blonde Lager', '12.1', 'American Lager', 'Flagship beer from the flagship brewery in Western PA'),
((select brewery_id from breweries where brewery_name = 'Kyle Beer Co'), 'TomA Porter', '12.5', 'Porter', 'Dark and strong porter created by the infamous Tom Anderson');


insert into reviews (user_id, beer_id, rating, review_body)
values
(1, 1, 5, 'It is the greatest beer in all the VERLD!'),
(1, 2, 4, 'Slimy, yet satisfying!'),
(2, 1, 5, '5 out of 5!'),
(2, 3, 4, 'Better than OK, not great');
insert into reviews (user_id, brewery_id, rating, review_body)
values
(1, 1, 5, 'Great establishment!'),
(1, 2, 4, 'Great beer, food just OK'),
(2, 1, 5, 'Great selection of beer, not just all IPAs like some places');

---------------------Filter by brewery, characteristisc etc.-------------------------
select * from beers
join breweries using (brewery_id)
where brewery_name = 'Kyle Beer Co'
order by abv desc;

select * from reviews where beer_id = 1;

