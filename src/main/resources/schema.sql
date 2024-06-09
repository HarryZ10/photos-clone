create table if not exists photo (
    _id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    _file_name varchar(255),
    _content_type varchar(255),
    _data binary large object
);
