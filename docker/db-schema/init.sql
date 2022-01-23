create schema test_db;

create table test_db.person (
    id int not null,
    name varchar(100) not null,
    constraint pk_person primary key (id)
);

insert into test_db.person(id, name) VALUES
(
 1, 'test name'
)