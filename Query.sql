/*Operazione 1:Registrare un nuovo abbonamento*/
INSERT INTO Gestore(codice_fiscale_gestore,nome,cognome,email)
VALUES ('CLCGRD94D20A509D','Gerardo','Colace','gcolace@gmail.com');

INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento annuale misto*/
VALUES ('annuale','misto','CLCGRD94D20A509D',250);

INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento semestrale sala pesi*/
VALUES ('semestrale','sala_pesi','CLCGRD94D20A509D',100);

INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento semestrale corso*/
VALUES ('semestrale','corso','CLCGRD94D20A509D',75);

INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento annuale sala pesi*/
VALUES ('annuale','sala_pesi','CLCGRD94D20A509D',200);

INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento mensile corso*/
VALUES ('mensile','corso','CLCGRD94D20A509D',15);

/*Operazione 2:Inserire un nuovo atleta*/
INSERT INTO Atleta(codice_fiscale_atleta,nome,cognome,email)
VALUES ('FRRFNC01P20I805J','Francesco','Ferrara','ferraraf682@gmail.com');/*Francesco*/

INSERT INTO Card(codice_card, codice_fiscale_atleta, nome, tipo, accessi)
VALUES ('DESA9854','FRRFNC01P20I805J','annuale','sala_pesi',1);

INSERT INTO Sottoscrive(codice_fiscale_atleta, nome, tipo, data_inizio, data_fine)
VALUES ('FRRFNC01P20I805J','annuale','sala_pesi','2022-06-06','2023-06-06');

INSERT INTO Atleta(codice_fiscale_atleta,nome,cognome,email)/*Alberto*/
VALUES ('RSSLRT03A01H703I','Alberto','Rossi','siciliano@gmail.com');

INSERT INTO Card(codice_card,codice_fiscale_atleta,nome, tipo, accessi)
VALUES ('MISA9854','RSSLRT03A01H703I','annuale','sala_pesi',1);

INSERT INTO Sottoscrive(codice_fiscale_atleta, nome, tipo, data_inizio, data_fine)
VALUES ('RSSLRT03A01H703I','annuale','sala_pesi','2022-07-12','2023-07-12');

INSERT INTO Atleta(codice_fiscale_atleta,nome,cognome,email)/*Samuel*/
VALUES ('TEOSML96H15H703J','Samuel','Etoo','samueletoo@gmail.com');

INSERT INTO Card(codice_card,codice_fiscale_atleta,nome,tipo,accessi)
VALUES ('MISA7890','TEOSML96H15H703J','semestrale','corso',1);

INSERT INTO Sottoscrive(codice_fiscale_atleta, nome, tipo, data_inizio, data_fine)
VALUES ('TEOSML96H15H703J','semestrale','corso','2020-01-12','2020-07-12');

/*Operazione 3:Aggiungere un nuovo dipendente*/
INSERT INTO Dipendente(codice_fiscale_dipendente,codice_fiscale_gestore,nome,cognome,email,retribuzione_annuale)
VALUES ('FRNSRA01R60A509X','CLCGRD94D20A509D','Sara','Fornace','sarafornace@gmail.com',20000);

INSERT INTO Dipendente(codice_fiscale_dipendente,codice_fiscale_gestore,nome,cognome,email,retribuzione_annuale)
VALUES ('FNZLNS00A01A509E','CLCGRD94D20A509D','Alfonso','Fanzi','alfanzi@gmail.com',20000);

INSERT INTO Dipendente(codice_fiscale_dipendente,codice_fiscale_gestore,nome,cognome,email,retribuzione_annuale)
VALUES ('DNILSS95A41F839D','CLCGRD94D20A509D','Alessia','Diana','odiana@gmail.com',20000);

/*Operazione 4:Aggiungere un nuovo corso*/
INSERT INTO Istruttore(codice_fiscale_istruttore,corso_a_carico)
VALUES ('FRNSRA01R60A509X',1);

INSERT INTO Corso(nome,codice_fiscale_istruttore,descrizione)
VALUES ('Breakdance','FRNSRA01R60A509X','Ballo acrobatico, nato 
negli anni 80 del Novecento in connessione con la musica rap 
come espressione dei gruppi giovanili dei quartieri neri di New York, 
caratterizzato da rapidi movimenti a scatti e da evoluzioni spettacolari.');

INSERT INTO Corso(nome,codice_fiscale_istruttore,descrizione)
VALUES ('Pugilato','FRNSRA01R60A509X','Sport agonistico nel quale due contendenti 
		si affrontano battendosi, secondo precisi regolamenti, con i pugni ricoperti da guantoni.');

UPDATE Istruttore AS I
					SET I.corso_a_carico= (
					SELECT COUNT(*) AS corsi_a_carico
					FROM Corso AS C
					WHERE I.codice_fiscale_istruttore = C.codice_fiscale_istruttore)
					WHERE I.codice_fiscale_istruttore = 'FRNSRA01R60A509X';

INSERT INTO Frequenta(nome,codice_fiscale_atleta)
VALUES ('Pugilato','FRRFNC01P20I805J');

/*Operazione 5:Aggiungere una nuova scheda*/
INSERT INTO Personal_trainer(codice_fiscale_pt)
VALUES ('FNZLNS00A01A509E');

INSERT INTO Personal_trainer(codice_fiscale_pt)
VALUES ('DNILSS95A41F839D');

INSERT INTO Scheda(codice_scheda,codice_fiscale_pt,descrizione)
VALUES ('IT490','FNZLNS00A01A509E','Panca piana 5x5, Croci ai cavi 4x8, Pulley 4x8, Leg extension 3x10, French Press 3x10');
	
INSERT INTO Scheda(codice_scheda,codice_fiscale_pt,descrizione)
VALUES ('IT500','FNZLNS00A01A509E','Squat 6x4, Leg press 3x10/12, Panca 30 manubri 4x8, Rematore bil. 3x12, Curl ai cavi 3x10');

INSERT INTO Scheda(codice_scheda,codice_fiscale_pt,descrizione)
VALUES ('IT510','DNILSS95A41F839D','Stacchi da terra 8x3, leg curl 3x12, Shoulder press 4x8, Dip 3xmax, Push down 3x10');

/*Operazione 6:Inserire una nuova richiesta di una scheda*/
INSERT INTO Richiede(codice_fiscale_atleta,codice_scheda)
VALUES ('FRRFNC01P20I805J','IT510');

INSERT INTO Richiede(codice_fiscale_atleta,codice_scheda)
VALUES ('FRRFNC01P20I805J','IT500');

INSERT INTO Richiede(codice_fiscale_atleta,codice_scheda)
VALUES ('FRRFNC01P20I805J','IT490');

/*Operazione 7 Inserire un nuovo accesso di un atleta*/
UPDATE Card AS C
					SET C.accessi = C.accessi + 1
                    WHERE C.codice_fiscale_atleta='RSSLRT03A01H703I';
				
/*Operazione 8:Stampare nome,cognome e retribuzione annuale di tutti i dipendenti*/
SELECT nome,cognome,retribuzione_annuale
FROM Dipendente;

/*Operazione 9:Trovare il cognome degli istruttori che insegnano a più di un corso*/
SELECT D.cognome,I.corso_a_carico
FROM Istruttore AS I,Dipendente AS D
WHERE D.codice_fiscale_dipendente=I.codice_fiscale_istruttore
HAVING I.corso_a_carico > 1;

/*Operazione 10:Visualizzare il numero di atleti di un dato corso*/
SELECT C.nome,COUNT(A.nome) AS numero_atleti
FROM Frequenta AS F,Atleta AS A,Corso AS C
WHERE A.codice_fiscale_atleta=F.codice_fiscale_atleta AND C.nome='Breakdance';

/*Operazione 11:Visualizzare nome e cognome degli atleti che hanno richiesto più di 2 schede*/
SELECT DISTINCT A.nome,A.cognome
FROM Atleta AS A,Richiede AS R,Scheda AS S
WHERE A.codice_fiscale_atleta=R.codice_fiscale_atleta AND S.codice_scheda=R.codice_scheda
HAVING COUNT(R.codice_scheda) > 2;

/*Operazione 12:Leggi il numero di accessi di uno specifico atleta*/
SELECT accessi
FROM Card
WHERE codice_fiscale_atleta ='RSSLRT03A01H703I';

/*Operazione 13:Visualizzare il numero di corsi a carico di un istruttore*/
SELECT corso_a_carico
FROM Istruttore AS I,Dipendente AS D
WHERE I.codice_fiscale_istruttore= 'FRNSRA01R60A509X' AND D.codice_fiscale_dipendente='FRNSRA01R60A509X';

/*Operazione 14:Ordinare gli abbonamenti di tutti gli iscritti per data di scadenza*/
SELECT A.nome,A.cognome,S.data_fine,A.email
FROM Sottoscrive AS S,Atleta AS A
WHERE S.codice_fiscale_atleta=A.codice_fiscale_atleta
ORDER BY data_fine ASC;

/*Operazione 15:Selezionare nome e cognome dei Personal Trainer che si sono occupati di almeno 3 schede*/
SELECT D.nome,D.cognome
FROM Dipendente AS D,Personal_trainer AS PT,Scheda AS S
WHERE PT.codice_fiscale_pt=S.codice_fiscale_pt AND D.codice_fiscale_dipendente=PT.codice_fiscale_pt
HAVING COUNT(S.codice_scheda) >= 3;
 
/*Operazione 16:Selezionare nome e cognome degli iscritti che frequentano almeno un corso*/
SELECT A.nome,A.cognome
FROM Atleta AS A ,Frequenta AS F
WHERE A.codice_fiscale_atleta=F.codice_fiscale_atleta;

/*Operazione 17:Selezionare l'email di tutti gli atleti che non hanno sottoscritto un determinato tipo di abbonamento*/
SELECT A.email
FROM Atleta AS A
WHERE NOT EXISTS(
	SELECT Ab.nome
    FROM Abbonamento AS Ab,Sottoscrive AS S
    WHERE Ab.nome=S.nome AND S.codice_fiscale_atleta=A.codice_fiscale_atleta AND Ab.tipo='misto'
);

/*Operazione 18:Selezionare l'email di tutti gli atleti che hanno una determinata scheda*/
SELECT A.email
FROM Atleta AS A
WHERE NOT EXISTS(
	SELECT S.codice_scheda
    FROM Scheda AS S,Richiede AS R
    WHERE S.codice_scheda='IT490' AND R.codice_fiscale_atleta=A.codice_fiscale_atleta
);


