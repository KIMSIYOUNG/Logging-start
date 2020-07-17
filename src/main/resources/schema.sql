

create table if not exists MEMBER
(
    ID   bigint auto_increment primary key,
    NAME varchar(255),
    ROLE varchar(255)
);

CREATE TABLE if not exists LOGGING_EVENT
(
    timestmp          bigint NOT NULL,
    formatted_message text NOT NULL,
    logger_name       VARCHAR(255) NOT NULL,
    level_string      VARCHAR(255) NOT NULL,
    reference_flag    smallint,
    caller_filename   VARCHAR(255) NOT NULL,
    caller_class      VARCHAR(255) NOT NULL,
    caller_method     VARCHAR(255) NOT NULL,
    caller_line       char(16) NOT NULL,
    event_id          integer NOT NULL,
    PRIMARY KEY(event_id)
);

CREATE TABLE if not exists LOGGING_EVENT_PROPERTY
(
    event_id     integer  NOT NULL,
    mapped_key   VARCHAR(255) NOT NULL,
    mapped_value text,
    PRIMARY KEY (event_id, mapped_key),
    FOREIGN KEY (event_id) REFERENCES logging_event (event_id)
);

CREATE TABLE if not exists logging_event_exception
(
    event_id   int  NOT NULL,
    i          SMALLINT     NOT NULL,
    trace_line VARCHAR(255) NOT NULL,
    PRIMARY KEY (event_id, i),
    FOREIGN KEY (event_id) REFERENCES logging_event (event_id)
);
