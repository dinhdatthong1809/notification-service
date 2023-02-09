create table notification_message
(
    id                 bigint primary key,
    content            text,
    created_by         text,
    created_date       date,
    last_modified_by   text,
    last_modified_date date,
    is_deleted         bool default false
);