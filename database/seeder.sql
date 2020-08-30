USE shearup_db;

# SHOW GRANTS for 'root'@'localhost';
# DROP DATABASE IF EXISTS shearup_db;
# TRUNCATE table_name;

# Images Table
INSERT INTO images (id, filestack_url, service_id)
VALUES (1, 'https://cdn.filestackcontent.com/AsXkBLtTybLfQCsHT0QW', 1);
INSERT INTO images (id, filestack_url, service_id)
VALUES (2, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 2);
INSERT INTO images (id, filestack_url, service_id)
VALUES (3, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 3);
INSERT INTO images (id, filestack_url, service_id)
VALUES (4, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 4);
INSERT INTO images (id, filestack_url, service_id)
VALUES (5, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 5);
INSERT INTO images (id, filestack_url, service_id)
VALUES (6, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 6);
INSERT INTO images (id, filestack_url, service_id)
VALUES (7, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 7);
INSERT INTO images (id, filestack_url, service_id)
VALUES (8, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 8);
INSERT INTO images (id, filestack_url, service_id)
VALUES (9, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 9);
INSERT INTO images (id, filestack_url, service_id)
VALUES (10, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 10);


# Reviews Table
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (1, 'Easy to connect with.', 'Thank you for connecting with me on such short notice!', 4.0, 1);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (2, 'Best barber in town!', 'My spouse loved that I finally managed to find a barber who could provide house calls. Thanks again!', 5.0, 2);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (3, 'Great Communication.', 'No complaints.', 5.0, 3);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (4, 'Very professional', 'Replies quickly.', 4.0, 4);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (5, 'Okay experience', 'Think better communication next time on when to meet up would help this barber out.', 2.0, 5);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (6, 'Will definitely schedule again!', '', 5.0, 6);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (7, 'Dope skills', 'Shout out to this barber for helping me look fresh.', 4.0, 7);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (8, 'Wish I could give more than five stars!', 'Thanks for helping me look almost normal again during this pandemic.', 5.0, 8);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (9, 'Awesome flexible hours.', 'Works in shop or will come to your home. Very convenient', 5.0, 9);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (10, 'Good shearing skills.', 'Can see why with so many years of experience this barber knows what they are doing.', 5.0, 10);

# Locations Table
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (1, '14510 NW Military Hwy #103', null, 'San Antonio', 'TX', 78231);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (2, '1207 San Francisco', null, 'San Antonio', 'TX', 78201);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (3, '7322 Jones Maltsberger Rd', 'Suite 214', 'San Antonio', 'TX', 78209);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (4, '23718 IH-West 10', '#114', 'San Antonio', 'TX', 78257);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (5, '122 E Houston St #104', null, 'San Antonio', 'TX', 78205);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (6, '5002 Eisenhauer Rd', null, 'San Antonio', 'TX', 78218);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (7, '4745 Fredericksburg Rd', null, 'San Antonio', 'TX', 78229);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (8, '315 E Commerce St # 102', null, 'San Antonio', 'TX', 78205);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (9, '1802 S St Marys St', null, 'San Antonio', 'TX', 78210);
INSERT INTO locations (id, address_one, address_two, city, state, zip_code)
VALUES (10, '443 McCarty Rd', null, 'San Antonio', 'TX', 78216);

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
VALUES (1, 'Beard Trim', 'Shampoo treatment with light trim to enhance desired style', '15.00', 30, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (2, 'Buzz Cut', 'Typical quick cut. Discounts available for active duty and responders.', '13.00', 20, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (3, 'High and Tight plus Eyebrow wax', 'Nothing looks better than cleaned up eyebrows and a nice clean cut.', '20.00', 25, 1);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (4, 'Kids Cut', 'Easy going when handling your child/s first cut.', '20.00', 30, 2);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (5, 'Taper Fade', 'Just a regular tapper to best suit your style.', '16.00', 20, 2);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (6, 'Wedding Special', 'This service package comes with hours worth of stying for you and all groomsmen. Please request an appointment at least a week in advance.', '300.00', 90, 3);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (7, 'Straight Razor Shave', 'Working remote can get tough. Early house calls available to get you ready for the rest of your work day.', '15.00', 25, 3);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (8, 'Caveman Beard Conditioning Treatment', 'If COVID has got you looking rough, feel free to contact me to put some life back into your style.', '25.00', 45, 4);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (9, 'Long haircut', 'Tired of split ends? Expect the best shears for you with my own personal technique.', '45.00', 30, 5);
INSERT INTO services (id, title, description, price, duration, barber_details_id)
VALUES (10, 'Grey Hair Blending Treatment', 'Lay your grey hair to rest with this quick and easy treatment!', '55.00', 60, 5);



# any user with 123 on the username are a Client user
# Users Table
INSERT INTO users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (1, 'albert92', 'Albert', 'Cudd', 'acudd0@mail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 1);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (2, 'yoli21', 'Yolanda', 'Sanchez', 'yoli21@gmail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 2);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (3, 'martin123', 'Martin', 'Dormand', 'mdormand2@time.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (4, 'jerome123', 'Jerome', 'Richards', 'jrichards3@scribd.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (5, 'susie79', 'Susan', 'Stormouth', 'mstormouth4@themeforest.net', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 3);
INSERT INTO users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (6, 'hank123', 'Hank', 'Hill', 'hank@yahoo.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 4);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (7, 'bobby20', 'Robert', 'Smith', 'robert@gizmodo.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 5);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (8, 'jane123', 'Jane', 'Doe', 'jane@mail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (9, 'greg123', 'Greg', 'Jett', 'greg@mail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (10, 'tina1968', 'Tina', 'Turner', 'tina78@mail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 6);
INSERT INTO users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (11, 'joey1987', 'Joseph', 'Dirt', 'joe@mail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 7);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (12, 'ramoni93', 'Ramon', 'Ramon', 'ramon@yahoo.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 8);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (13, 'michael123', 'Michael', 'Garrison', 'michael@gmail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (14, 'chris123', 'Chris', 'Eckert', 'chris@yahoo.com', '%20$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 0, null);
INSERT INTO  users (id, username, first_name, last_name, email, password, is_barber, barber_detail_id)
VALUES (15, 'knoahknows92', 'Knoah', 'Cotto', 'kcotto@mail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1, 9);


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

