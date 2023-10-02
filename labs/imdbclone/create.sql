
    create table celebrity (
        birth_year integer,
        death_year integer,
        id varchar(200) not null,
        primary_name varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table movie (
        runtime_minutes integer,
        year integer,
        id varchar(200) not null,
        genres varchar(1000),
        title varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table movie_celebrity (
        celebrity_id varchar(200) not null,
        movie_id varchar(200) not null,
        category varchar(1000),
        characters varchar(1000),
        primary key (celebrity_id, movie_id)
    ) engine=InnoDB;

    alter table movie_celebrity 
       add constraint FKae7pb34r7sn4574j0fmfkhlxy 
       foreign key (celebrity_id) 
       references celebrity (id) 
       on delete cascade;

    alter table movie_celebrity 
       add constraint FK9hk25dpcaq5c31fj63350eq4a 
       foreign key (movie_id) 
       references movie (id) 
       on delete cascade;
