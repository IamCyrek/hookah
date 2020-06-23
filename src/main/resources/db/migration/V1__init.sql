CREATE TABLE restaurant
(
    id                      BIGSERIAL PRIMARY KEY,
    name                    VARCHAR(255)  NOT NULL,
    description             VARCHAR(2047) NOT NULL,
    address                 VARCHAR(255)  NOT NULL,
    number                  VARCHAR(15)   NOT NULL,
    latitude                REAL,
    longitude               REAL,
    rating                  SMALLINT      NOT NULL,
    max_number_reservations SMALLINT,
    UNIQUE (name)
);

CREATE TABLE public.user
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    email         VARCHAR(63)  NOT NULL,
    password      VARCHAR(63)  NOT NULL,
    created_at    TIMESTAMP    NOT NULL,
    is_enabled    BOOLEAN      NOT NULL,
    smoking_time  BIGINT       NOT NULL,
    restaurant_id BIGINT REFERENCES restaurant (id),
    UNIQUE (email)
);

CREATE TABLE reservation
(
    id                    BIGSERIAL PRIMARY KEY,
    restaurant_id         BIGINT REFERENCES restaurant (id)  NOT NULL,
    user_id               BIGINT REFERENCES public.user (id) NOT NULL,
    start_time            TIMESTAMP                          NOT NULL,
    visitors_number       SMALLINT
);

CREATE TABLE role
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    UNIQUE (name)
);

CREATE TABLE user_role
(
    user_id BIGINT REFERENCES public.user (id) NOT NULL,
    role_id BIGINT REFERENCES role (id)        NOT NULL,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE tobacco
(
    id                BIGSERIAL PRIMARY KEY,
    custom_tobacco_id VARCHAR(31)  NOT NULL,
    name              VARCHAR(255) NOT NULL,
    profile           VARCHAR(4095),
    UNIQUE (name)
);

CREATE TABLE tobacco_restaurant
(
    tobacco_id    BIGINT REFERENCES tobacco (id)    NOT NULL,
    restaurant_id BIGINT REFERENCES restaurant (id) NOT NULL,
    status        VARCHAR(15)                       NOT NULL,
    amount        SMALLINT,
    PRIMARY KEY (tobacco_id, restaurant_id)
);

CREATE TABLE hookah
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    charge        SMALLINT,
    status        VARCHAR(15)  NOT NULL,
    restaurant_id BIGINT REFERENCES restaurant (id),
    UNIQUE (name)
);

CREATE TABLE hookah_history
(
    id               BIGSERIAL PRIMARY KEY,
    hookah_id        BIGINT REFERENCES hookah (id)      NOT NULL,
    tobacco_id       BIGINT REFERENCES tobacco (id)     NOT NULL,
    administrator_id BIGINT REFERENCES public.user (id) NOT NULL,
    visitor_id       BIGINT REFERENCES public.user (id) NOT NULL,
    restaurant_id    BIGINT REFERENCES restaurant (id)  NOT NULL,
    cash             NUMERIC(10, 2)                     NOT NULL,
    start_time       TIMESTAMP,
    end_time         TIMESTAMP
);

CREATE TABLE account_level
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    value BIGINT       NOT NULL,
    UNIQUE (name)
);

CREATE TABLE restaurant_review
(
    user_id       BIGINT REFERENCES public.user (id) NOT NULL,
    rating        SMALLINT                           NOT NULL,
    comment       VARCHAR(255),
    restaurant_id BIGINT REFERENCES restaurant (id)  NOT NULL,
    PRIMARY KEY (user_id, restaurant_id)
);

CREATE TABLE favourite_restaurant
(

    user_id       BIGINT REFERENCES public.user (id) NOT NULL,
    restaurant_id BIGINT REFERENCES restaurant (id)  NOT NULL,
    PRIMARY KEY (user_id, restaurant_id)
);

CREATE TABLE chat
(
    id            BIGSERIAL PRIMARY KEY,
    user_id       BIGINT REFERENCES public.user (id) NOT NULL,
    message       VARCHAR(255)                       NOT NULL,
    creation_time TIMESTAMP
);
