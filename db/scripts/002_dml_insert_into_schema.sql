insert into files(name, path) values('avatar.jpg', 'files/avatar.jpg');
insert into files(name, path) values('elemental.jpg', 'files/elemental.jpg');
insert into files(name, path) values('it.jpg', 'files/it.jpg');

insert into genres(name) values('horror');
insert into genres(name) values('fantastic');
insert into genres(name) values('cartoon');

insert into films(name, description, "year", genre_id, minimal_age, duration_in_minutes, file_id) values('Avatar', 'Description Avatar', 2009, 2, 12, 162, 1);
insert into films(name, description, "year", genre_id, minimal_age, duration_in_minutes, file_id) values('It', 'Description It', 2017, 1, 18, 135, 3);
insert into films(name, description, "year", genre_id, minimal_age, duration_in_minutes, file_id) values('Elemental', 'Description Elemental', 2023, 3, 6, 101, 2);

insert into halls(name, row_count, place_count, description) values('Hall1', 15, 225, 'Big hall');
insert into halls(name, row_count, place_count, description) values('Hall2', 6, 42, 'Small hall');

insert into film_sessions(film_id, halls_id, start_time, end_time, price) values(1, 1, '2023-10-15 14:00:00', '2023-10-15 16:42:00', 7);
insert into film_sessions(film_id, halls_id, start_time, end_time, price) values(2, 2, '2023-10-15 11:00:00', '2023-10-15 12:41:00', 4);
insert into film_sessions(film_id, halls_id, start_time, end_time, price) values(3, 1, '2023-10-17 18:00:00', '2023-10-17 20:15:00', 6);
