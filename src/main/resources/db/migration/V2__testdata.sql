INSERT INTO restaurant (id, name, description, address, number, rating, max_number_reservations)
VALUES (1, 'test_name', 'test_description', 'test_address', '+375291234567', 3, 6);
ALTER SEQUENCE restaurant_id_seq RESTART WITH 2;

INSERT INTO role (id, name)
VALUES (1, 'ROLE_FULL_ACCESS'),
       (2, 'ROLE_STAFF');
ALTER SEQUENCE role_id_seq RESTART WITH 3;

INSERT INTO public.user (id, name, email, password, created_at, is_enabled, smoking_time, restaurant_id)
VALUES (1, 'test_name', 'email@test_email.com', '$2a$10$jaaloVVZ61dVT9LnbggpLeTU/V4tv6DjTaeETMwWU5Wqhu/mSEwDe', localtimestamp, true, 10, 1);
ALTER SEQUENCE user_id_seq RESTART WITH 2;

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1);

INSERT INTO tobacco (id, custom_tobacco_id, name)
VALUES (1, 'Al Fakher Banana', 'AAAAAAFA7B00'),
       (2, 'Al Fakher Mango', 'AAAAAA47D69A'),
       (3, 'Starbuzz Black Grape', 'AAAAABD34B1D'),
       (4, 'Fumari Ambrosia', 'AAAAACECB94C'),
       (5, 'Starbuzz Chocolate Mint', 'AAAAAB1C30E1'),
       (6, 'Starbuzz Holiday Mix', 'AAAAABCD8C66'),
       (7, 'Fumari Island Papaya', 'AAAAAC2A17CE'),
       (8, 'Fumari Mojito Mojo', 'AAAAACEAF797');
ALTER SEQUENCE tobacco_id_seq RESTART WITH 9;

INSERT INTO hookah (id, name, charge, status, restaurant_id)
VALUES (1, 'test_name_1_restaurant_1', 100, 'READY', 1),
       (2, 'test_name_2_restaurant_1', 30, 'NOT_READY', 1);
ALTER SEQUENCE hookah_id_seq RESTART WITH 3;

INSERT INTO hookah_history (id, hookah_id, tobacco_id, administrator_id, visitor_id, restaurant_id, cash)
VALUES (1, 1, 1, 1, 1, 1, 70);
ALTER SEQUENCE hookah_history_id_seq RESTART WITH 2;

INSERT INTO account_level (id, name, value)
VALUES (1, 'START LEVEL', 0),
       (2, 'STANDARD LEVEL', 10),
       (3, 'VIP LEVEL', 50),
       (4, 'PREMIUM LEVEL', 140),
       (5, 'MEGA  LEVEL', 560);
ALTER SEQUENCE account_level_id_seq RESTART WITH 6;

INSERT INTO restaurant_review (user_id, rating, restaurant_id)
VALUES (1, 3, 1);

INSERT INTO favourite_restaurant (user_id, restaurant_id)
VALUES (1, 1);

INSERT INTO chat (id, user_id, message, creation_time)
VALUES (1, 1, 'test_message_1', localtimestamp);
ALTER SEQUENCE chat_id_seq RESTART WITH 2;
