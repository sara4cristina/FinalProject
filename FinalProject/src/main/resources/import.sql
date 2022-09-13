insert into client (cui, nume_client, telefon_client) values ('RO23114432', 'CocaCola Romania', '0213457892');
insert into client (cui, nume_client, telefon_client) values ('RO4324543', 'Heidi Chocolate', '0723547392');
insert into client (cui, nume_client, telefon_client) values ('RO345643', 'Tuborg Company', '0213468722');

insert into buletin (cnp, serie_nr) values ('1870523470035','IF432553');
insert into buletin (cnp, serie_nr) values ('1780324470035','BV5439854');
insert into buletin (cnp, serie_nr) values ('1750923470054','IF432553');

insert into masina (capacitate_masina, numar_masina) values ('12','IF45SCM');
insert into masina (capacitate_masina, numar_masina) values ('17', 'IF47SCM');
insert into masina (capacitate_masina, numar_masina) values ('14', 'IF53SCM');


insert into sofer (nume_sofer, prenume_sofer, telefon_sofer, id_buletin, id_masina) values ('Stan', 'Marian', '0732107208','1','1');
insert into sofer (nume_sofer, prenume_sofer, telefon_sofer, id_buletin, id_masina) values ('Boboc', 'Cristian', '0754327208','2','3');
insert into sofer (nume_sofer, prenume_sofer, telefon_sofer, id_buletin, id_masina) values ('Iustea', 'Tinel', '0765445085','3','2');


insert into cerere (data, plecare, sosire, pret,  client_id, rezervare) values ('2015-10-1','Bucuresti','Suceava','56.6','1','NEREZERVAT');
insert into cerere (data, plecare, sosire, pret,  client_id, rezervare) values ('2015-12-1','Bucuresti','Brasov','23.6','3','NEREZERVAT');
insert into cerere (data, plecare, sosire, pret,  client_id, rezervare) values ('2015-10-18','Bucuresti','Craiova','24.8','3','NEREZERVAT');
insert into cerere (data, plecare, sosire, pret,  client_id, rezervare) values ('2015-10-19','Bucuresti','Baia Mare','66.8','2', 'NEREZERVAT');