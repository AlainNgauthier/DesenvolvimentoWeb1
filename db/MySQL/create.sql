/*drop database if exists CompraVendaVeiculo;

create database CompraVendaVeiculo;*/

use CompraVendaVeiculo;


/*create table Cliente(id bigint not null auto_increment,email varchar(30) not null, senha varchar(50) not null, cpf varchar(20) not null, nome varchar (50) not null,
telefone varchar(20) not null, sexo varchar(10) not null, nascimento varchar(10) not null, papel varchar(10) not null, primary key(id));

create table Loja(id bigint not null auto_increment, email varchar(30) not null, senha varchar(50) not null, cnpj varchar(20), nome varchar (50) not null, 
descricao varchar(120),primary key(id));

create table Veiculo(id bigint not null auto_increment, placa varchar(20) not null, modelo varchar(20) not null,
chassi varchar(17) not null, ano integer not null, quilometragem integer not null, descricao varchar(120) not null, 
valor float not null,id_loja bigint not null, primary key(id),foreign key(id_loja) references Loja(id));

create table Proposta(id bigint not null auto_increment,id_cliente bigint not null, id_loja bigint not null, id_veiculo bigint not null,
valor float not null, data_p varchar(10) not null, estado varchar(11) not null, parcelamento varchar(11) not null, primary key(id), 
foreign key(id_cliente) references Cliente(id),foreign key(id_loja) references Loja(id),
foreign key(id_veiculo) references Veiculo(id));

insert into Cliente(email,senha,cpf,nome,telefone,sexo,nascimento,papel) values ('cliente1@gmail.com','cliente1','111.111.111-11',
'cliente1','1111111111','M','2000-01-01','USER');
insert into Cliente(email,senha,cpf,nome,telefone,sexo,nascimento,papel) values ('admin','admin','cpf_admin',
'admin1','12345678','M','1997-08-20','ADMIN');

insert into Loja(email,senha,cnpj,nome,descricao) values ('loja1@gmail.com','loja1','111.111.111/0001-11','loja1','LOJA1');
insert into Loja(email,senha,cnpj,nome,descricao) values ('loja2@gmail.com','loja2','222.222.222/0001-11','loja2','LOJA2');


insert into Veiculo(placa,modelo,chassi,ano,quilometragem,descricao,valor,id_loja) 
values ('0001111', 'Bolt','1A1A1111111111111',2017,1000, 'Chevrolet',27350,1);
*/

insert into Veiculo(placa, modelo, chassi, ano, quilometragem, descricao, valor, id_loja) 
values ('0001112', 'Compass', '1A1A1111111111111', 2020, 400, 'Chevrolet', 79350.50, 1);




/*insert into Proposta(id_cliente,id_loja,id_veiculo, valor,data_p, estado, parcelamento) values (1,1,1,25000,'2022-08-01', 'ABERTO',10);*/

/*insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I49', 'chassi', 'Bolt', 'Chevrolet', 2017, 443.55, 27350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I48', 'chassi', 'Cruze', 'Chevrolet', 2008, 943.55, 27350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I47', 'chassi', 'Menlo', 'Chevrolet', 2020, 59.00, 27350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I46', 'chassi', 'Onix', 'Chevrolet', 2012, 7543.75, 27350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I44', 'chassi', 'Compass', 'Chevrolet', 2020, 1.50, 79350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I43', 'chassi', 'Grand Cherokee', 'Cherokee', 2020, 3.55, 87350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('60.724.444/0001-00', 'LSN4I42', 'chassi', 'Wrangler', 'Chevrolet', 2020, 4.50, 97350.00);

insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('55.789.390/0008-00', 'LSN8I41', 'chassi', 'E-Class Sedan', 'Mercedes', 2012, 1234.55, 200350.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('55.789.390/0008-00', 'LSN8I42', 'chassi', 'Ultra-Intelligent', 'Mercedes', 2012, 1234.55, 243580.00);
insert into Veiculo(cnpj, placa, chassi, modelo, descricao, ano, kilometragem, valor) values ('55.789.390/0008-00', 'LSN8I43', 'chassi', 'A-Class Sedans', 'Mercedes', 2012, 1234.55, 163580.00);

*/

