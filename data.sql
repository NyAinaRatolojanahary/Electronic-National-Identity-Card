-- postgresql

insert into province(id,province_name) values('Prv1','Antananarivo');
insert into province(id,province_name) values('Prv2','Toamasina');
insert into province(id,province_name) values('Prv3','Mahajanga');
insert into province(id,province_name) values('Prv4','Toliara');
insert into province(id,province_name) values('Prv5','Antsiranana');
insert into province(id,province_name) values('Prv6','Fianarantsoa');


insert into region(id,region_name,idprovince) values('Reg1','Analamanga','Prv1');
insert into region(id,region_name,idprovince) values('Reg2','Itasy','Prv1');
insert into region(id,region_name,idprovince) values('Reg3','Vakinakaratra','Prv1');
insert into region(id,region_name,idprovince) values('Reg4','Haute-Matsiatra','Prv6');
insert into region(id,region_name,idprovince) values('Reg5','AmoroniMania','Prv6');
insert into region(id,region_name,idprovince) values('Reg6','Atsinanana','Prv2');
insert into region(id,region_name,idprovince) values('Reg7','Alaotra Mangoro','Prv2');
insert into region(id,region_name,idprovince) values('Reg8','Sava','Prv5');
insert into region(id,region_name,idprovince) values('Reg9','Diana','Prv5');
insert into region(id,region_name,idprovince) values('Reg10','Anosy','Prv4');
insert into region(id,region_name,idprovince) values('Reg11','Androy','Prv4');
insert into region(id,region_name,idprovince) values('Reg12','Betsiboka','Prv3');


insert into district(id,district_name,idregion) values('Dis1','Antananarivo Atsimondrano','Reg1');
insert into district(id,district_name,idregion) values('Dis2','Miarinarivo','Reg2');
insert into district(id,district_name,idregion) values('Dis3','Antsirabe','Reg3');
insert into district(id,district_name,idregion) values('Dis4','Fianarantsoa','Reg4');
insert into district(id,district_name,idregion) values('Dis5','Ambositra','Reg5');
insert into district(id,district_name,idregion) values('Dis6','Toamasina','Reg6');
insert into district(id,district_name,idregion) values('Dis7','Ambatondrazaka','Reg7');
insert into district(id,district_name,idregion) values('Dis8','Antsiranana','Reg8');
insert into district(id,district_name,idregion) values('Dis9','Betroka','Reg10');
insert into district(id,district_name,idregion) values('Dis10','Mahajanga','Reg12');


insert into commune(id,commune_name,iddistrict) values('Com1','CR Andoharanofotsy','Dis1');
insert into commune(id,commune_name,iddistrict) values('Com2','CU Miarinarivo','Dis2');
insert into commune(id,commune_name,iddistrict) values('Com3','CU Antsirabe','Dis3');
insert into commune(id,commune_name,iddistrict) values('Com4','CU Fianarantsoa','Dis4');
insert into commune(id,commune_name,iddistrict) values('Com5','CU Ambositra','Dis5');
insert into commune(id,commune_name,iddistrict) values('Com6','CU Toamasina','Dis6');
insert into commune(id,commune_name,iddistrict) values('Com7','CU Ambatondrazaka','Dis7');
insert into commune(id,commune_name,iddistrict) values('Com8','CU Antsiranana','Dis8');
insert into commune(id,commune_name,iddistrict) values('Com9','CU Betroka','Dis9');
insert into commune(id,commune_name,iddistrict) values('Com10','CU Mahajanga','Dis10');
insert into commune(id,commune_name,iddistrict) values('Com11','CU Antananarivo','Dis1');


insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs1','Rakoto','Jaona','01-02-1971','Com1','Mahabo Andoharanofotsy',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs2','Rabe','Marka','02-03-1981','Com2','Miarinarivo Itasy',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs3','Randria','Lioka','03-04-1991','Com3','Antsirabe Vakinakaratra',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs4','Ravao','Matio','04-05-1972','Com4','Fianarantsoa Haute-matsiatra',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs5','Razafy','Jodasy','05-06-1982','Com5','Ambositra Amoronimania',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs6','Ralala','Petera','06-07-1992','Com6','Toamasina Antsinanana',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs7','Ranoa','Simona','07-08-1973','Com7','Ambatomndrazaka Alaotra Mangoro',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs8','Ratany','Tomasy','08-09-1983','Com8','Antsiranana SAVA',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs9','Ranja','Jakoba','09-10-1993','Com9','Betroka Anosy',1);
insert into person(id,family_name,first_name,birthday,idcommune_birth,location,gender) values('Prs10','Rahary','Filipo','10-11-1974','Com10','mahajanga Betsiboka',1);


insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin1','Prs1','01-02-1989','Com1','Apostoly');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin2','Prs2','02-03-1999','Com2','Mpanaradia');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin3','Prs3','03-04-2009','Com3','Dokotera');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin4','Prs4','04-05-1990','Com4','Mpamory hetra');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin5','Prs5','05-06-2000','Com5','Mpamadika');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin6','Prs6','06-07-2010','Com6','Mpanarato');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin7','Prs7','07-08-1991','Com7','Mpanaradia');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin8','Prs8','08-09-2001','Com8','Kely Finoana');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin9','Prs9','09-10-2011','Com9','Mpanjono');
insert into cin(id,idperson,delivery_date,idcommune,profession) values('Cin10','Prs10','10-11-1992','Com10','Mpianatra');


insert into hospital(id,hospital_name,location,idcommune_location) values(,'','','','');
insert into hospital(id,hospital_name,location,idcommune_location) values(,'','','','');
insert into hospital(id,hospital_name,location,idcommune_location) values(,'','','','');
insert into hospital(id,hospital_name,location,idcommune_location) values(,'','','','');
insert into hospital(id,hospital_name,location,idcommune_location) values(,'','','','');
insert into hospital(id,hospital_name,location,idcommune_location) values(,'','','','');


insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');
insert into health_action(id,action_name,) values(,'');


insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');
insert into health_action_history(id,idperson,idhospital,idhealth_action,action_date,note) values(,'','','','','');


CREATE SEQUENCE seqprv
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;

CREATE SEQUENCE seqreg
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;

CREATE SEQUENCE seqdis
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;

CREATE SEQUENCE seqcom
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;

CREATE SEQUENCE seqprs
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;


CREATE SEQUENCE seqcin
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;

CREATE SEQUENCE seqhsp
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;

CREATE SEQUENCE seqhac
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;


CREATE SEQUENCE seqhah
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999
    CACHE 1;


CREATE OR REPLACE FUNCTION getseqprv() 
    RETURNS integer AS $$
    DECLARE 
        seq integer;
    BEGIN
        SELECT nextval('seqprv') INTO seq;
        RETURN seq;
    END;
$$ LANGUAGE plpgsql;


insert into devise(id,nomdevise) values (default,'MGA');
insert into devise(id,nomdevise) values (default,'EUR');
insert into devise(id,nomdevise) values (default,'USD');

insert into cours_devise(id,iddevise,somme,datedevise) values (default,1,1,'2022-01-01');
insert into cours_devise(id,iddevise,somme,datedevise) values (default,2,4810,'2022-01-01');
insert into cours_devise(id,iddevise,somme,datedevise) values (default,3,4400,'2022-01-01');

-- mysql

insert into count_type values('Ct1','Compte Etudiant');
insert into count_type values('Ct2','Compte Simple');
insert into count_type values('Ct3','Compte Epargne');
insert into count_type values('Ct4','Compte Pro');
insert into count_type values('Ct5','Compte Entreprise');


insert into bank values('Bk1','BFV','Antaninarenina','Com11');
insert into bank values('Bk2','BNI','Analakely','Com11');
insert into bank values('Bk3','BOA','Tanjombato','Com11');
insert into bank values('Bk4','BMOI','Ivandry','Com11');


insert into bank_count values('Bc1','Ct1','Cin1','Bk1');
insert into bank_count values('Bc2','Ct2','Cin2','Bk2');
insert into bank_count values('Bc3','Ct3','Cin3','Bk3');
insert into bank_count values('Bc4','Ct4','Cin4','Bk4');
insert into bank_count values('Bc5','Ct5','Cin5','Bk1');
insert into bank_count values('Bc6','Ct1','Cin6','Bk2');
insert into bank_count values('Bc7','Ct2','Cin7','Bk3');
insert into bank_count values('Bc8','Ct3','Cin8','Bk4');
insert into bank_count values('Bc9','Ct4','Cin9','Bk1');
insert into bank_count values('Bc10','Ct1','Cin10','Bk2');

insert into bank_action_type (id,nomAction) values(default,'Transfert');
insert into bank_action_type (id,nomAction) values(default,'Depot');
insert into bank_action_type (id,nomAction) values(default,'Retrait');
insert into bank_action_type (id,nomAction) values(default,'Recu');



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

insert into bank_count_history(id,idbank_action_type,iddevise,somme,dateAction,idsender,idrecipient) values(default,2,1,1000000,'2022-01-10','Cin1','Cin1'); 
insert into bank_count_history(id,idbank_action_type,iddevise,somme,dateAction,idsender,idrecipient) values(default,2,1,500000,'2022-01-10','Cin2','Cin2'); 
insert into bank_count_history(id,idbank_action_type,iddevise,somme,dateAction,idsender,idrecipient) values(default,2,1,90000,'2022-01-10','Cin1','Cin1'); 
insert into bank_count_history(id,idbank_action_type,iddevise,somme,dateAction,idsender,idrecipient) values(default,2,1,0,'2022-01-10','Cin2','Cin2'); 




-- SqlServer
insert into landed_status(id,landed_status) values('Lst1','Titre');
insert into landed_status(id,landed_status) values('Lst2','Borne');
insert into landed_status(id,landed_status) values('Lst3','Cadastrer');
insert into landed_status(id,landed_status) values('Lst4','Vendue Acte de vente');
insert into landed_status(id,landed_status) values('Lst5','Neutre');


insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('1','Mahatazana',540.89,'Com1','Dis1','Lst1','Cin1');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('2','Amoronkady',400,'Com1','Dis1','Lst2','Cin2');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('3','Mahavokatra',1000,'Com2','Dis2','Lst3','Cin3');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('4','Mahamanina',450.60,'Com3','Dis3','Lst4','Cin4');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('5','Tanana',800,'Com4','Dis4','Lst1','Cin5');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('6','Mahafinaritra',250,'Com5','Dis5','Lst2','Cin6');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('7','Mahasoa',440,'Com6','Dis6','Lst3','Cin7');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('8','Mahafaly',2000,'Com7','Dis7','Lst4','Cin8');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('9','Mahagaga',1300,'Com8','Dis8','Lst1','Cin9');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('10','Tany soa',2500,'Com9','Dis9','Lst2','Cin10');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('11','Ambato',500,'Com10','Dis10','Lst3','Cin1');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('12','Ankazo',600,'Com1','Dis1','Lst4','Cin2');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('13','Amorondrano',750,'Com2','Dis2','Lst1','Cin3');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('14','Mahamamo',480,'Com3','Dis3','Lst2','Cin4');
insert into property(id,property_name,property_size,sector,district,idlanded_status,idowner) values('15','Mahanoana',920,'Com4','Dis4','Lst3','Cin5');


-- Insert some data
INSERT INTO PointsOfInterest (ID, Name, Location)
VALUES 
    (1, 'Park', Geometry::Point(47.6204, -122.3491, 4326)), -- Seattle coordinates
    (2, 'Museum', Geometry::Point(40.7128, -74.0060, 4326)); -- New York coordinates


insert into property_landmark(id,idproperty,landmark) values (1,1, Geometry::Point( 47.54287445952857,-18.96253786774891, 4326));
insert into property_landmark(id,idproperty,landmark) values (2,1, Geometry::Point( 47.5429884534117,-18.96249981801162, 4326));
insert into property_landmark(id,idproperty,landmark) values (3,1, Geometry::Point( 47.54299381782973,-18.96281182560112, 4326));
insert into property_landmark(id,idproperty,landmark) values (4,1, Geometry::Point( 47.543076966309194,-18.9627407995345, 4326));