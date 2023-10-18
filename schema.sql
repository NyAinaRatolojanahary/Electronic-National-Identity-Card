-- postgresql
create database health;

\c health

create table province(
    id varchar(15) primary key,
    province_name varchar(20)
);

create table region(
    id varchar(15) primary key,
    region_name varchar(30),
    idprovince varchar(15),
    foreign key (idprovince) references province(id)
);

create table district(
    id varchar(15) primary key,
    district_name varchar(30),
    idregion varchar(15),
    foreign key (idregion) references region(id)
);

create table commune(
    id varchar(15) primary key,
    commune_name varchar(30),
    iddistrict varchar(15),
    foreign key (iddistrict) references district(id)
);

create table person(
    id varchar(15) primary key,
    family_name varchar(40),
    first_name varchar(40),
    birthday timestamp,
    idcommune_birth varchar(15),
    location varchar(40),
    gender integer,
    foreign key (idcommune_birth) references commune(id)
);

create table cin(
    id varchar(15) primary key,
    idperson varchar(15),
    delivery_date date,
    idcommune varchar(15),
    profession varchar(40),
    foreign key (idperson) references person(id),
    foreign key (idcommune) references commune(id)
);

create table hospital(
    id varchar(15) primary key,
    hospital_name varchar(50),
    location varchar(40),
    idcommune_location varchar(15),
    foreign key (idcommune_location) references commune(id)
);

create table health_action(
    id varchar(10) primary key,
    action_name varchar(20)
);

create table health_action_history(
    id varchar(10) primary key,
    idperson varchar(15),
    idhospital varchar(15),
    idhealth_action varchar(10),
    action_date date,
    note varchar,
    foreign key (idperson) references person(id),
    foreign key (idhospital) references hospital(id),
    foreign key (idhealth_action) references health_action(id)
);

create table devise(
    id serial primary key,
    nomdevise varchar(10)
);

create table cours_devise(
    id serial primary key,
    iddevise int,
    somme double precision,
    datedevise date,
    tauxVente double precision,
    foreign key (iddevise) references devise(id)
);

-- mysql

create database bank;

use bank;
\c bank

create table count_type(
    id varchar(15) primary key,
    count_name varchar(20)
);

create table bank(
    id varchar(15) primary key,
    bank_name varchar(30),
    bank_location varchar(40),
    idcommune_location varchar(15)
);

create or replace table bank_count(
    id varchar(15) primary key,
    idcount_type varchar(15),
    cin varchar(15),
    idbank varchar(15),
    iddevise int,
    foreign key (idcount_type) references count_type(id),
    foreign key (idbank) references bank(id)
);

create table bank_action_type(
    id serial primary key,
    nomAction varchar(15)
);


-- create table bank_count_history(
--     id varchar(15) primary key,
--     history_status int,
--     idbank_count varchar(15),
--     amount double precision,
--     history_date timestamp,
--     note varchar(255),
--     foreign key (idbank_count) references bank_count(id)
-- );

create table bank_count_history(
    id serial primary key,
    idbank_action_type int,
    iddevise int,
    somme double precision,
    dateAction date,
    idsender varchar(15),
    idrecipient varchar(15),
    foreign key (idbank_action_type) references bank_action_type(id)
);

-- SqlServer

create table landed_status(
    id varchar(15) primary key,
    landed_status varchar(20)
);

create table property(
    id varchar(15) primary key,
    property_name varchar(20),
    property_size double precision,
    sector varchar(30),
    district varchar(30),
    idlanded_status varchar(10),
    idowner varchar(10)
);

create table property_history_type(
    id varchar(15) primary key,
    property_history_type varchar(20)
);

create table property_history(
    id varchar(15) primary key,
    idproperty varchar(15),
    idproperty_history_type varchar(15),
    idold_owner varchar(15),
    idnew_owner varchar(15),
    foreign key (idproperty) references property(id),
    foreign key (idproperty_history_type) references property(id)
);