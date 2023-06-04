DROP SCHEMA IF EXISTS Palestra;
CREATE SCHEMA IF NOT EXISTS Palestra;
USE Palestra;

/*Atleta(Codice Fiscale, nome, cognome, e-mail)*/
CREATE TABLE IF NOT EXISTS Atleta(
codice_fiscale_atleta char(16) NOT NULL,
nome varchar(20) NOT NULL,
cognome varchar(20) NOT NULL, 
email varchar(30) NOT NULL,
PRIMARY KEY(codice_fiscale_atleta)
);

/*Gestore(Codice Fiscale, nome, cognome, email)*/
CREATE TABLE IF NOT EXISTS Gestore(
codice_fiscale_gestore char(16) NOT NULL,
nome varchar(20) NOT NULL,
cognome varchar(20) NOT NULL, 
email varchar(30) NOT NULL,
PRIMARY KEY(codice_fiscale_gestore)
);

/*Abbonamento(nome, tipo, gestore.codiceFiscale↑, costo)*/
CREATE TABLE IF NOT EXISTS Abbonamento(
nome varchar(15) NOT NULL,
tipo varchar(14) NOT NULL,
codice_fiscale_gestore char(16) NOT NULL,
costo int NOT NULL, 
PRIMARY KEY(nome, tipo),
FOREIGN KEY(codice_fiscale_gestore) REFERENCES Gestore(codice_fiscale_gestore) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Sottoscrive(atleta.codiceFiscale↑, abbonamento.nome↑, abbonamento.tipo↑, dataInizio, dataFine)*/
CREATE TABLE IF NOT EXISTS Sottoscrive(
codice_fiscale_atleta char(16) NOT NULL,
nome varchar(15) NOT NULL,
tipo varchar(14) NOT NULL,
data_inizio date NOT NULL,
data_fine date NOT NULL,
PRIMARY KEY(codice_fiscale_atleta, nome, tipo),
FOREIGN KEY(codice_fiscale_atleta) REFERENCES Atleta(codice_fiscale_atleta) ON UPDATE CASCADE ON DELETE CASCADE, 
FOREIGN KEY(nome, tipo) REFERENCES Abbonamento(nome, tipo) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Card(CodCard, atleta.codiceFiscale↑, abbonamento.nome, abbonamento.tipo↑, #accessi)*/
CREATE TABLE IF NOT EXISTS Card(
codice_card varchar(15) NOT NULL,
codice_fiscale_atleta char(16) NOT NULL,
nome varchar(15) NOT NULL,
tipo varchar(14) NOT NULL, 
accessi int DEFAULT 0,
PRIMARY KEY(codice_card, codice_fiscale_atleta, nome, tipo),
FOREIGN KEY(codice_fiscale_atleta) REFERENCES Atleta(codice_fiscale_atleta) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(nome, tipo) REFERENCES Abbonamento(nome, tipo) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Dipendente(Codice Fiscale,gestore.codiceFiscale↑, nome, cognome, e-mail,retribuzione annuale)*/
CREATE TABLE IF NOT EXISTS Dipendente(
codice_fiscale_dipendente char(16) NOT NULL,
codice_fiscale_gestore char(16),
nome varchar(20) NOT NULL,
cognome varchar(20) NOT NULL, 
email varchar(30) NOT NULL,
retribuzione_annuale bigint NOT NULL,
PRIMARY KEY(codice_fiscale_dipendente),
FOREIGN KEY(codice_fiscale_gestore) REFERENCES Gestore(codice_fiscale_gestore) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Istruttore(dipendente.codiceFiscale↑,#corso_a_carico)*/
CREATE TABLE IF NOT EXISTS Istruttore(
codice_fiscale_istruttore char(16) NOT NULL,
corso_a_carico int DEFAULT 0,
PRIMARY KEY(codice_fiscale_istruttore),
FOREIGN KEY(codice_fiscale_istruttore) REFERENCES Dipendente(codice_fiscale_dipendente) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Corso(Nome, istruttore.codiceFiscale↑, descrizione)*/
CREATE TABLE IF NOT EXISTS Corso(
nome varchar(20) NOT NULL,
codice_fiscale_istruttore char(16) NOT NULL,
descrizione varchar(3000), 
PRIMARY KEY(nome),
FOREIGN KEY(codice_fiscale_istruttore) REFERENCES Istruttore(codice_fiscale_istruttore) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Frequenta(corso.nome↑, atleta.codiceFiscale↑)*/
CREATE TABLE IF NOT EXISTS Frequenta(
nome varchar(20) NOT NULL,
codice_fiscale_atleta char(16) NOT NULL,
PRIMARY KEY(nome,codice_fiscale_atleta),
FOREIGN KEY(nome) REFERENCES Corso(nome) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(codice_fiscale_atleta) REFERENCES Atleta(codice_fiscale_atleta) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Personal Trainer(dipendente.codiceFiscale↑)*/
CREATE TABLE IF NOT EXISTS Personal_trainer(
codice_fiscale_pt char(16) NOT NULL,
PRIMARY KEY(codice_fiscale_pt),
FOREIGN KEY(codice_fiscale_pt) REFERENCES Dipendente(codice_fiscale_dipendente) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Scheda(codScheda, PT.codiceFiscale↑, descrizione)*/
CREATE TABLE IF NOT EXISTS Scheda(
codice_scheda varchar(15) NOT NULL,
codice_fiscale_pt char(16) NOT NULL,
descrizione varchar(1000),
PRIMARY KEY(codice_scheda),
FOREIGN KEY(codice_fiscale_pt) REFERENCES Personal_trainer(codice_fiscale_pt) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Richiede(atleta.codiceFiscale↑, scheda.codScheda↑)*/
CREATE TABLE IF NOT EXISTS Richiede(
codice_fiscale_atleta char(16) NOT NULL,
codice_scheda varchar(15) NOT NULL,
PRIMARY KEY(codice_fiscale_atleta,codice_scheda),
FOREIGN KEY(codice_fiscale_atleta) REFERENCES Atleta(codice_fiscale_atleta) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(codice_scheda) REFERENCES Scheda(codice_scheda) ON UPDATE CASCADE ON DELETE CASCADE
);

/*Telefono(Numero, gestore.codiceFiscale↑)*/
CREATE TABLE IF NOT EXISTS Telefono(
numero bigint NOT NULL,
codice_fiscale_gestore char(16) NOT NULL,
PRIMARY KEY(numero),
FOREIGN KEY(codice_fiscale_gestore) REFERENCES Gestore(codice_fiscale_gestore) ON UPDATE CASCADE ON DELETE CASCADE
);
