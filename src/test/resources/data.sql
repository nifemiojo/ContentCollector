-- INSERT CONTENT
insert into content (id, name, link) values (nextval('content_id_sequence'), 'Vitalik Talk', 'https://www.reddit.com/r/javahelp/comments/77zjx2/why_is_spring_so_hard_to_learn_with_so_bad/');
insert into content (id, name, link) values (nextval('content_id_sequence'), 'Google', 'www.google.com');

-- INSERT CATEGORY
insert into category (id, name) values (nextval('category_id_sequence'), 'ENTERTAINMENT');
insert into category (id, name) values (nextval('category_id_sequence'), 'BUSINESS');
insert into category (id, name) values (nextval('category_id_sequence'), 'LIFESTYLE');
insert into category (id, name) values (nextval('category_id_sequence'), 'SPORTS');
insert into category (id, name) values (nextval('category_id_sequence'), 'FUNNY');

-- INSERT CATEGORY TO CONTENT
update content set category_name = 'SPORTS' where id = 1;
update content set category_name = 'BUSINESS' where id = 2;
