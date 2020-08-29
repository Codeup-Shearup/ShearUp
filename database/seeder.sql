# DROP DATABASE IF EXISTS shearup_db;
USE shearup_db;

# SHOW GRANTS for 'root'@'localhost';

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


# Reviews Table
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (1, 'Easy to connect with.', 'consectetuer eget rutrum at lorem', 4.5, 1, 1);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (2, 'Best barber in town!', 'libero non mattis pulvinar nulla pede ullamcorper augue a', 5.0, 2, 2);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (3, 'Great Communication', 'proin interdum mauris non ligula pellentesque', 4.0, 3, 3);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (4, 'Very professional', 'rhoncus mauris enim leo rhoncus sed vestibulum', 4.5, 4, 4);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (5, 'Okay experience', 'sed magna at nunc commodo placerat praesent blandit nam nulla', 2.9, 5, 5);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (6, 'Will definitely schedule again!', 'eget congue eget semper rutrum nulla nunc purus phasellus in', 5.0, 6, 6);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (7, 'Dope skills', 'id nisl venenatis lacinia aenean', 4.1, 7, 7);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (8, 'Quick responder!', 'diam neque vestibulum eget vulputate', 4.0, 8, 8);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
VALUES (9, 'Awesome barber', 'sed vestibulum sit amet cursus', 5.0, 9, 9);
INSERT INTO reviews (id, title, content, rating, image_id, user_id)
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

# Barber Details Table
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (1, 'House calls available, with COVID precautions', 8302834028, 'Monday-Friday, 9am-9pm', 1);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (2, 'Hablo español! Espero verlos pronto.', 7871234567, 'Tuesday-Saturday, 8am-8pm', 2);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (3, 'Best barber in all of Texas. Check out my portfolio, it speaks for itself.', 210345687, 'Monday-Friday, 9am-9pm', 3);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (4, 'Superior cuts and the best fades, every time. Just checkout my reviews!', 8302384921, 'Monday-Saturday, 7am-7pm', 4);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (5, 'Best barber in town! Feel free to call anytime.', 210675687, 'Monday-Friday, 9am-9pm', 5);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (6, 'Will drive up to 25 miles to provide the best cuts!', 830945687, 'Monday-Saturday, 10am-7pm', 6);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (7, 'Reservations for weddings available upon request.', 912345664, 'Monday-Friday, 9am-9pm', 7);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (8, 'Over ten years experience here. So no worries you are in capable hands!', 912346382, 'Monday-Friday, 9am-9pm', 8);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (9, 'Skilled barber here! Let us connect', 787233091, 'Monday-Friday, 9am-9pm', 9);
INSERT INTO barber_details (id, bio, phone, hours_of_work, location_id)
VALUES (10, 'Pretty skilled with shears, have you seen my portfolio?', 2108394120, 'Monday-Friday, 9am-9pm', 10);

# Services Table
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (1, 'Beard Trim', '', '23.00', 30, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (2, 'Buzz Cut', '', '15.00', 20, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (3, 'High and Tight plus Eyebrow wax', '', '7.00', 25, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (4, 'Kids Cut', '', '20.00', 30, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (5, 'Taper Fade', '', '16.00', 20, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (6, 'Wedding Special', 'amet nunc viverra dapibus nulla suscipit', '13.00', 20, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (7, 'Straight Razor Shave', 'volutpat in congue etiam justo etiam pretium iaculis', '15.00', 25, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (8, 'Beard Conditioning Treatment', 'sit amet nulla quisque arcu libero', '25.00', 45, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (9, 'Long haircut', 'primis in faucibus orci luctus et ultrices posuere', '17.00', 30, 2);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (10, 'Grey Hair Blending Treatment', 'ut blandit non interdum in ante vestibulum', '55.00', 60, 2);



# any user with 123 on the username are a Client user
# Users Table
INSERT INTO users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (1, 'albert92', 'Albert', 'Cudd', 'acudd0@mail.com', 'albert', 1, 1);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (2, 'yoli21', 'Yolanda', 'Sanchez', 'yoli21@gmail.com', 'yolanda', 1, 2);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (3, 'martin123', 'Martin', 'Dormand', 'mdormand2@time.com', 'martin', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (4, 'jerome123', 'Jerome', 'Richards', 'jrichards3@scribd.com', 'jerome', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (5, 'susie79', 'Susan', 'Stormouth', 'mstormouth4@themeforest.net', 'susan', 1, 3);
INSERT INTO users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (6, 'hank123', 'Hank', 'Hill', 'hank@yahoo.com', 'hank', 1, 4);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (7, 'bobby20', 'Robert', 'Smith', 'robert@gizmodo.com', 'robert', 1, 5);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (8, 'jane123', 'Jane', 'Doe', 'jane@mail.com', 'jane', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (9, 'greg123', 'Greg', 'Jett', 'greg@mail.com', 'greg', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (10, 'tina78', 'Tina', 'Turner', 'tina78@mail.com', 'tina', 1, 6);
INSERT INTO users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (11, 'joey', 'Joe', 'Dirt', 'joe@mail.com', 'joe', 1, 7);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (12, 'ramoni', 'Ramon', 'Ramon', 'ramon@yahoo.com', 'ramon', 1, 8);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (13, 'michael123', 'Michael', 'Garrison', 'michael@gmail.com', 'michael', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (14, 'chris123', 'Chris', 'Eckert', 'chris@yahoo.com', 'chris', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (15, 'kcotto', 'Knoah', 'Cotto', 'kcotto@mail.com', 'knoah', 1, 9);


# Appointments Table
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (1, 1, 1, '2020-08-01 08:30');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (2, 2, 2, '2020-08-01 09:30');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (3, 2, 3, '2020-08-01 10:30');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (4, 3, 4, '2020-08-15 12:30');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (5, 5, 5, '2020-08-19 09:00');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (6, 5, 6, '2020-08-01 08:30');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (7, 4, 7, '2020-08-01 07:30');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (10, 3, 10, '2020-08-01 11:30');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (9, 2, 9, '2020-08-15 12:00');
# INSERT INTO appointments (id, user_id, service_id, create_date_time) VALUES (8, 1, 8, '2020-08-17 08:30');

