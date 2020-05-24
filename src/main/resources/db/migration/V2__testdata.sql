INSERT INTO role (id, name)
VALUES (1, 'ROLE_FULL_ACCESS'),
       (2, 'ROLE_STAFF');
ALTER SEQUENCE role_id_seq RESTART WITH 3;

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

INSERT INTO account_level (id, name, value)
VALUES (1, 'START LEVEL', 0),
       (2, 'STANDARD LEVEL', 10),
       (3, 'VIP LEVEL', 50),
       (4, 'PREMIUM LEVEL', 140),
       (5, 'MEGA  LEVEL', 560);
ALTER SEQUENCE account_level_id_seq RESTART WITH 6;
