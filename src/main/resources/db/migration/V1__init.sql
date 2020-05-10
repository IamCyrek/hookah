CREATE TABLE public.user
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    email      VARCHAR(63)  NOT NULL,
    password   VARCHAR(63)  NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    is_enabled BOOLEAN      NOT NULL,
    UNIQUE (email)
);

CREATE TABLE role
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    UNIQUE (name)
);

CREATE TABLE user_role
(
    user_id BIGINT REFERENCES public.user (id),
    role_id BIGINT REFERENCES role (id),
    PRIMARY KEY (user_id, role_id)
);
