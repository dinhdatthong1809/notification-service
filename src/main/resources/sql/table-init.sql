create table notification
(
    id                 bigserial primary key,
    topic_id           text,
    title              text,
    content            text,
    created_by         text,
    created_date       date,
    last_modified_by   text,
    last_modified_date date,
    is_deleted         bool default false
);