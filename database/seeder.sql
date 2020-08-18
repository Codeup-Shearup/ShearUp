USE shearup_db;

# Users Table
INSERT INTO users (id, username, first_name, last_name, email, password, is_barber, barber_details_id)
VALUES (1, 'Barber1', 'Albert', 'Cudd', 'acudd0@mac.com', 'iX0R2rtCQ', 1, 1);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_details_id)
VALUES (2, 'Barber2', 'Yolanda', 'Breawood', 'ybreawood1@gizmodo.com', 'Ayx82M2v3wPr', 1, 2);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_details_id)
VALUES (3, 'User1', 'Martin', 'Dormand', 'mdormand2@time.com', 'YWLESLF', 0, 3);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_details_id)
VALUES (4, 'User2', 'Jerome', 'Richards', 'jrichardes3@scribd.com', 'uoEj4UtqHk', 0, 4);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_details_id)
VALUES (5, 'Barber3', 'Susan', 'Stormouth', 'mstormouth4@themeforest.net', 'dfD9WAUjoH', 1, 5);


# Barber Details Table
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (1, 'Best barber in all of Texas!', 1, 1);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (2, 'Pretty skilled with shear not going to lie.', 2, 2);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (3, 'Cheers to the Shears!', 3, 3);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (4, 'Superior cuts found here with me.', 4, 4);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (5, 'nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis', 5, 5);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (6, 'porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in', 6, 6);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (7, 'luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac', 7, 7);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (8, 'aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed', 8, 8);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (9, 'adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy', 9, 9);
INSERT INTO barber_details (id, bio, location_id, image_id)
VALUES (10, 'quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus', 10, 10);

# Appointments Table
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (1, 1, 1, '08/18/2020 08:30');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (2, 2, 2, '08/18/2020 09:30');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (3, 2, 3, '08/19/2020 10:30');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (4, 3, 4, '08/19/2020 12:30');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (5, 5, 5, '08/19/2020 09:00');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (6, 6, 6, '08/20/2020 08:30');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (7, 7, 7, '08/20/2020 07:30');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (10, 10, 10, '08/21/2020 11:30');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (9, 9, 9, '08/21/2020 12:00');
INSERT INTO appointments (id, user_id, service_id, appointment_date) VALUES (8, 8, 8, '08/20/2020 08:30');

# Services Table
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (1, 'Gentlemen Cut', 'natoque penatibus et magnis dis', '23.00', 30, 1);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (2, 'Bald Fade', 'pede lobortis ligula sit amet', '15.00', 20, 1);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (3, 'Beard Trim', 'dapibus dolor vel est donec odio justo sollicitudin ut', '7.00', 25, 1);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (4, 'Kids Cut', 'ut blandit non interdum in ante vestibulum ante', '20.00', 30, 1);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (5, 'Taper', 'luctus et ultrices posuere cubilia curae', '16.00', 20, 1);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (6, 'Military Cut', 'amet nunc viverra dapibus nulla suscipit', '13.00', 20, 1);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (7, 'Straight Razor Shave', 'volutpat in congue etiam justo etiam pretium iaculis', '15.00', 25, 1);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (8, 'Beard Conditioning Treatment', 'sit amet nulla quisque arcu libero', '25.00', 45, 1);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (9, 'Long haircut', 'primis in faucibus orci luctus et ultrices posuere', '17.00', 30, 2);
INSERT INTO services (id, name, description, price, duration, barber_details_id)
VALUES (10, 'Grey Hair Blending Treatment', 'ut blandit non interdum in ante vestibulum', '55.00', 60, 2);

# Reviews Table
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (1, 'Easy to connect with.', 'consectetuer eget rutrum at lorem', 4.5, 1, 1);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (2, 'Best barber in town!', 'libero non mattis pulvinar nulla pede ullamcorper augue a', 5.0, 2, 2);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (3, 'Great Communication', 'proin interdum mauris non ligula pellentesque', 4.0, 3, 3);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (4, 'Very professional', 'rhoncus mauris enim leo rhoncus sed vestibulum', 4.5, 4, 4);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (5, 'Okay experience', 'sed magna at nunc commodo placerat praesent blandit nam nulla', 2.9, 5, 5);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (6, 'Will definitely schedule again!', 'eget congue eget semper rutrum nulla nunc purus phasellus in', 5.0, 6, 6);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (7, 'Dope skills', 'id nisl venenatis lacinia aenean', 4.1, 7, 7);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (8, 'Quick responder!', 'diam neque vestibulum eget vulputate', 4.0, 8, 8);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (9, 'Awesome barber', 'sed vestibulum sit amet cursus', 5.0, 9, 9);
INSERT INTO reviews (id, title, content, rating, image_id, appointment_id)
VALUES (10, 'Good skills', 'turpis integer aliquet massa id', 3.5, 10, 10);


# Locations Table
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (1, '21783 Clove Point', 'Way', 'Houston', 'TX', 78257);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (2, '42040 Mariners Cove Alley', 'Junction', 'Norwalk', 'CT', 78266);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (3, '729 Fordem Alley', 'Trail', 'Atlanta', 'GA', 78205);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (4, '9 Annamark Street', 'Lane', 'Sacramento', 'CA', 78228);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (5, '67 Delladonna Trail', 'Center', 'Tallahassee', 'FL', 78250);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (6, '25408 Westport Street', 'Place', 'North Hollywood', 'CA', 78298);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (7, '69283 Fieldstone Trail', 'Pass', 'Birmingham', 'AL', 78286);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (8, '81 Thierer Road', 'Circle', 'New Orleans', 'LA', 78227);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (9, '44449 Bowman Park', 'Crossing', 'Dallas', 'TX', 78296);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (10, '92 Emmet Terrace', 'Drive', 'Greensboro', 'NC', 78279);


# Images Table
INSERT INTO images (id, filestack_url, service_id)
VALUES (1, 'http://dummyimage.com/145x209.png/ff4444/ffffff', 1);
INSERT INTO images (id, filestack_url, service_id)
VALUES (2, 'http://dummyimage.com/141x248.png/5fa2dd/ffffff', 2);
INSERT INTO images (id, filestack_url, service_id)
VALUES (3, 'http://dummyimage.com/150x222.bmp/dddddd/000000', 3);
INSERT INTO images (id, filestack_url, service_id)
VALUES (4, 'http://dummyimage.com/174x111.png/cc0000/ffffff', 4);
INSERT INTO images (id, filestack_url, service_id)
VALUES (5, 'http://dummyimage.com/101x187.jpg/dddddd/000000', 5);
INSERT INTO images (id, filestack_url, service_id)
VALUES (6, 'http://dummyimage.com/125x188.bmp/ff4444/ffffff', 6);
INSERT INTO images (id, filestack_url, service_id)
VALUES (7, 'http://dummyimage.com/125x175.bmp/5fa2dd/ffffff', 7);
INSERT INTO images (id, filestack_url, service_id)
VALUES (8, 'http://dummyimage.com/126x222.bmp/ff4444/ffffff', 8);
INSERT INTO images (id, filestack_url, service_id)
VALUES (9, 'http://dummyimage.com/144x203.bmp/ff4444/ffffff', 9);
INSERT INTO images (id, filestack_url, service_id)
VALUES (10, 'http://dummyimage.com/198x122.bmp/5fa2dd/ffffff', 10);
INSERT INTO images (id, filestack_url, service_id)
VALUES (11, 'http://dummyimage.com/165x101.bmp/cc0000/ffffff', 11);
INSERT INTO images (id, filestack_url, service_id)
VALUES (12, 'http://dummyimage.com/102x194.bmp/cc0000/ffffff', 12);
INSERT INTO images (id, filestack_url, service_id)
VALUES (13, 'http://dummyimage.com/145x105.jpg/5fa2dd/ffffff', 13);
INSERT INTO images (id, filestack_url, service_id)
VALUES (14, 'http://dummyimage.com/187x196.bmp/dddddd/000000', 14);
INSERT INTO images (id, filestack_url, service_id)
VALUES (15, 'http://dummyimage.com/184x113.jpg/dddddd/000000', 15);



