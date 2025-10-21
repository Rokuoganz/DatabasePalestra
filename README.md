# Progetto-BD: Database Palestra

## Overview
Questo progetto è stato realizzato per il corso di Basi di Dati della facoltà di Informatica dell'Università degli Studi di Salerno.

## Autori
<a href="https://github.com/Rokuoganz/DatabasePalestra/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Rokuoganz/DatabasePalestra" />
</a>

* [Francesco Ferrara](https://github.com/Rokuoganz)

## Obiettivi
- Apprendere le tecniche di gestione e strutturazione di un database.

## Strumenti e Tecnologie
<div style="display: flex; align-items: center; gap: 30px;">
  <img src="https://upload.wikimedia.org/wikipedia/commons/8/87/Sql_data_base_with_logo.png" width="100"/>
  <img src="https://upload.wikimedia.org/wikipedia/labs/8/8e/Mysql_logo.png" width="100"/>
  <img src="https://upload.wikimedia.org/wikipedia/it/2/2e/Java_Logo.svg" width="50"/>
  <img src="https://upload.wikimedia.org/wikipedia/commons/d/d0/Eclipse-Luna-Logo.svg" width="100"/>
</div>

- SQL: linguaggio in cui sono scritte le query del DB.
- MySQL: database utilizzato.
- Java: il linguaggio tramite il quale è stata strutturata l'interfaccia.
- Eclipse: IDE utilizzato per la programmazione in Java.

## Struttura del Progetto
- [DocumentazioneDB/PalestraBD4.0.pdf](DocumentazioneDB/PalestraBD4.0.pdf): Documentazione del progetto
- [DatabasePalestra/Palestra1/](DatabasePalestra/Palestra1/): Cartella contenente i codici JAVA.
- [DatabasePalestra/ScriptsDBPalestra/](DatabasePalestra/ScriptsDBPalestra/): Directory contenente i file SQL.

## Installazione e Uso
1. Clonare il repository e apri il progetto in Eclipse.
2. In MySQL Workbench (o equivalente) eseguire lo script SQL presente nella cartella DocumentazioneDB per creare il database e le tabelle.
3. In Eclipse configurare la connessione JDBC (URL, utente, password) nel codice Java e assicurarsi che il driver MySQL sia nel classpath.
4. Eseguire la classe Java principale per popolamento/interrogazione del database e verificare che l’applicazione funzioni correttamente.
