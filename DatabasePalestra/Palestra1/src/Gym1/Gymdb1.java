package Gym1;

import java.sql.*;

public class Gymdb1 {

	public Gymdb1() {
		try {
			DBConnectionPool.createDBConnection();
			this.con = DBConnectionPool.getConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void releaseConnection() {
		DBConnectionPool.releaseConnection(con);
	}
	
	public void query01() {
		try {
			System.out.println("Registrare un nuovo abbonamento:\n\n");
			
			String query = "INSERT INTO Gestore(codice_fiscale_gestore,nome,cognome,email)\r\n"
					+ "VALUES ('CLCGRD94D20A509D','Gerardo','Colace','gcolace@gmail.com');";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			query = "INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento annuale misto*/\r\n"
					+ "VALUES ('annuale','misto','CLCGRD94D20A509D',250);";
			st = con.createStatement();
			st.executeUpdate(query);

			query = "INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento semestrale sala pesi*/\r\n"
					+ "VALUES ('semestrale','sala_pesi','CLCGRD94D20A509D',100);";
			st = con.createStatement();
			st.executeUpdate(query);
			
			query= "INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento semestrale corso*/\r\n"
					+ "VALUES ('semestrale','corso','CLCGRD94D20A509D',75);";
			st = con.createStatement();
			st.executeUpdate(query);
			
			query = "INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento annuale sala pesi*/\r\n"
					+ "VALUES ('annuale','sala_pesi','CLCGRD94D20A509D',200);";
			st = con.createStatement();
			st.executeUpdate(query);
			
			query= "INSERT INTO Abbonamento(nome, tipo, codice_fiscale_gestore,costo)/*Abbonamento mensile corso*/\r\n"
					+ "VALUES ('mensile','corso','CLCGRD94D20A509D',15);";
			st = con.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Inserimento effettuato.");
		}
		catch(Exception e) {
			System.err.print(e.getMessage());
		}
	}
	
	public void query02() {
		try {
			System.out.println("Inserire un nuovo atleta:\n\n");
			
			String query = "INSERT INTO Atleta(codice_fiscale_atleta,nome,cognome,email)\r\n"
					+ "VALUES ('FRRFNC01P20I805J','Francesco','Ferrara','ferraraf682@gmail.com');\r\n";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			query = "INSERT INTO Card(codice_card, codice_fiscale_atleta, nome, tipo, accessi)\r\n"
					+ "VALUES ('DESA9854','FRRFNC01P20I805J','annuale','sala_pesi',1);\r\n";
			st = con.createStatement();
			st.executeUpdate(query);
			
			query = "INSERT INTO Sottoscrive(codice_fiscale_atleta, nome, tipo, data_inizio, data_fine)\r\n"
					+ "VALUES ('FRRFNC01P20I805J','annuale','sala_pesi','2022-06-06','2023-06-06');\r\n";
			st = con.createStatement();
			st.executeUpdate(query);
			
			query = "INSERT INTO Atleta(codice_fiscale_atleta,nome,cognome,email)\r\n"
					+ "VALUES ('RSSLRT03A01H703I','Alberto','Rossi','siciliano@gmail.com');";
			st = con.createStatement();
			st.executeUpdate(query);

			query = "INSERT INTO Card(codice_card,codice_fiscale_atleta,nome, tipo, accessi)\r\n"
					+ "VALUES ('MISA9854','RSSLRT03A01H703I','annuale','sala_pesi',1);\r\n";
			st = con.createStatement();
			st.executeUpdate(query);

			query = "INSERT INTO Sottoscrive(codice_fiscale_atleta, nome, tipo, data_inizio, data_fine)\r\n"
					+ "VALUES ('RSSLRT03A01H703I','annuale','sala_pesi','2022-07-12','2023-07-12');\r\n";
			st = con.createStatement();
			st.executeUpdate(query);
			
			query = "INSERT INTO Atleta(codice_fiscale_atleta,nome,cognome,email)\r\n"
					+ "VALUES ('TEOSML96H15H703J','Samuel','Etoo','samueletoo@gmail.com');";
			st = con.createStatement();
			st.executeUpdate(query);

			query = "INSERT INTO Card(codice_card,codice_fiscale_atleta,nome,tipo,accessi)\r\n"
					+ "VALUES ('MISA7890','TEOSML96H15H703J','semestrale','corso',1);\r\n";
			st = con.createStatement();
			st.executeUpdate(query);

			query = "INSERT INTO Sottoscrive(codice_fiscale_atleta, nome, tipo, data_inizio, data_fine)\r\n"
					+ "VALUES ('TEOSML96H15H703J','semestrale','corso','2020-01-12','2020-07-12');\r\n";
			st = con.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Inserimento effettuato.");
		}
		catch(Exception e) {
			System.err.print(e.getMessage());
		}
	}
	
		public void query03() {
			try {
				System.out.println("Aggiungere un nuovo dipendente:\n\n");
				
				String query = "INSERT INTO Dipendente(codice_fiscale_dipendente,codice_fiscale_gestore,nome,cognome,email,retribuzione_annuale)\r\n"
						+ "VALUES ('FRNSRA01R60A509X','CLCGRD94D20A509D','Sara','Fornace','sarafornace@gmail.com',20000);\r\n";
				Statement st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Dipendente(codice_fiscale_dipendente,codice_fiscale_gestore,nome,cognome,email,retribuzione_annuale)\r\n"
						+ "VALUES ('FNZLNS00A01A509E','CLCGRD94D20A509D','Alfonso','Fanzi','alfanzi@gmail.com',20000);\r\n";
				st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Dipendente(codice_fiscale_dipendente,codice_fiscale_gestore,nome,cognome,email,retribuzione_annuale)\r\n"
						+ "VALUES ('DNILSS95A41F839D','CLCGRD94D20A509D','Alessia','Diana','odiana@gmail.com',20000);\r\n";
				st = con.createStatement();
				st.executeUpdate(query);

				
				System.out.println("Inserimento effettuato.");
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query04() {
			try {
				System.out.println("Aggiungere un nuovo corso:\n\n");
				
				String query = "INSERT INTO Istruttore(codice_fiscale_istruttore,corso_a_carico)\r\n"
						+ "VALUES ('FRNSRA01R60A509X',1);";
				Statement st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Corso(nome,codice_fiscale_istruttore,descrizione)\r\n"
						+ "VALUES ('Breakdance','FRNSRA01R60A509X','Ballo acrobatico, nato \r\n"
						+ "negli anni 80 del Novecento in connessione con la musica rap \r\n"
						+ "come espressione dei gruppi giovanili dei quartieri neri di New York, \r\n"
						+ "caratterizzato da rapidi movimenti a scatti e da evoluzioni spettacolari.');\r\n";
				st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Corso(nome,codice_fiscale_istruttore,descrizione)\r\n"
						+ "VALUES ('Pugilato','FRNSRA01R60A509X','Sport agonistico nel quale due contendenti \r\n"
						+ "	si affrontano battendosi, secondo precisi regolamenti, con i pugni ricoperti da guantoni.');\r\n";
				st = con.createStatement();
				st.executeUpdate(query);
				
				String updateString = 
						  " UPDATE Istruttore AS I\r\n"
						+ "	SET corso_a_carico= (\r\n"
						+ " SELECT COUNT(*) AS corsi_a_carico\r\n"
						+ "	FROM Corso AS C\r\n"
						+ "	WHERE I.codice_fiscale_istruttore = C.codice_fiscale_istruttore)\r\n"
						+ " WHERE I.codice_fiscale_istruttore = 'FRNSRA01R60A509X';\r\n";
				
				st = con.createStatement();
				st.executeUpdate(updateString);
				
				query = "INSERT INTO Frequenta(nome,codice_fiscale_atleta)\r\n"
						+ "VALUES ('Pugilato','FRRFNC01P20I805J');\r\n";
				st = con.createStatement();
				st.executeUpdate(query);
				
				System.out.println("Inserimento effettuato.");
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query05() {
			try {
				System.out.println("Aggiungere una nuova scheda:\n\n");
				
				String query = "INSERT INTO Personal_trainer(codice_fiscale_pt)\r\n"
						+ "VALUES ('FNZLNS00A01A509E');";
				Statement st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Personal_trainer(codice_fiscale_pt)\r\n"
						+ "VALUES ('DNILSS95A41F839D');";
				st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Scheda(codice_scheda,codice_fiscale_pt,descrizione)\r\n"
						+ "VALUES ('IT490','FNZLNS00A01A509E','Panca piana 5x5, Croci ai cavi 4x8,"
						+ " Pulley 4x8, Leg extension 3x10, French Press 3x10');\r\n";
				st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Scheda(codice_scheda,codice_fiscale_pt,descrizione)\r\n"
						+ "VALUES ('IT500','FNZLNS00A01A509E','Squat 6x4, Leg press 3x10/12,"
						+ " Panca 30 manubri 4x8, Rematore bil. 3x12, Curl ai cavi 3x10');\r\n";
				st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Scheda(codice_scheda,codice_fiscale_pt,descrizione)\r\n"
						+ "VALUES ('IT510','DNILSS95A41F839D','Stacchi da terra 8x3, leg curl 3x12,"
						+ " Shoulder press 4x8, Dip 3xmax, Push down 3x10');\r\n";
				st = con.createStatement();
				st.executeUpdate(query);
				
				System.out.println("Inserimento effettuato.");
				
				}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query06() {
			try {
				System.out.println("Inserire una nuova richiesta di una scheda:\n\n");
				
				String query = "INSERT INTO Richiede(codice_fiscale_atleta,codice_scheda)\r\n"
						+ "VALUES ('FRRFNC01P20I805J','IT510');";
				Statement st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Richiede(codice_fiscale_atleta,codice_scheda)\r\n"
						+ "VALUES ('FRRFNC01P20I805J','IT500');";
				st = con.createStatement();
				st.executeUpdate(query);
				
				query = "INSERT INTO Richiede(codice_fiscale_atleta,codice_scheda)\r\n"
						+ "VALUES ('FRRFNC01P20I805J','IT490');";
				st = con.createStatement();
				st.executeUpdate(query);
				
				System.out.println("Inserimento effettuato.");
				
				}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query07() {
			try {
				System.out.println("Operazione 7 Inserire un nuovo accesso di un atleta");
				
				String query = "UPDATE Card AS C\r\n"
						+ "					SET C.accessi = C.accessi + 1\r\n"
						+ "                 WHERE C.codice_fiscale_atleta='RSSLRT03A01H703I';";
				Statement st = con.createStatement();
				st.executeUpdate(query);
				
				System.out.println("Modifica effettuata.");
				
				}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query08() {
			try {
				System.out.println("Stampare nome,cognome e retribuzione annuale di tutti i dipendenti:\n\n");
				
				String query = "SELECT nome,cognome,retribuzione_annuale\r\n"
								+ "FROM Dipendente;";
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					String nome = res.getString("nome");
					String cognome = res.getString("cognome");
					int retribuzione_annuale = res.getInt("retribuzione_annuale");
					System.out.println(nome + " " + cognome + " " + retribuzione_annuale);
					tro = res.next();
				}
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query09() {
			try {
					System.out.println("Trovare il cognome degli istruttori che insegnano a più di un corso:\n\n");
					
					String query = "SELECT D.cognome,I.corso_a_carico\r\n"
							+ "FROM Istruttore AS I,Dipendente AS D\r\n"
							+ "WHERE D.codice_fiscale_dipendente=I.codice_fiscale_istruttore\r\n"
							+ "HAVING I.corso_a_carico > 1;";
					PreparedStatement cmd = con.prepareStatement(query);
					ResultSet res = cmd.executeQuery();
					boolean tro = res.next();
					while(tro) {
						String cognome = res.getString("cognome");
						System.out.println(cognome);
						tro = res.next();
				}
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query10() {
			try {
				System.out.println("Visualizzare il numero di atleti di un dato corso:\n\n");
				
				String query = "SELECT C.nome,COUNT(A.nome) AS numero_atleti\r\n"
								+ "FROM Frequenta AS F,Atleta AS A,Corso AS C\r\n"
								+ "WHERE A.codice_fiscale_atleta=F.codice_fiscale_atleta AND C.nome='Breakdance';";
				
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					int numero_atleti = res.getInt("numero_atleti");
					System.out.println(numero_atleti);
					tro = res.next();
				}
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query11() {
			try {
				System.out.println("Visualizzare nome e cognome degli atleti che hanno richiesto più di 2 schede:\n\n");
				
				String query = "SELECT DISTINCT A.nome,A.cognome\r\n"
						+ "FROM Atleta AS A,Richiede AS R,Scheda AS S\r\n"
						+ "WHERE A.codice_fiscale_atleta=R.codice_fiscale_atleta AND S.codice_scheda=R.codice_scheda\r\n"
						+ "HAVING COUNT(R.codice_scheda) > 2;";
				
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					String nome = res.getString("nome");
					String cognome = res.getString("cognome");
					System.out.println(nome + " " + cognome);
					tro = res.next();
				}
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query12() {
			try {
				System.out.println("Leggi il numero di accessi di uno specifico atleta:\n\n");
				
				String query = "SELECT accessi\r\n"
						+ "FROM Card\r\n"
						+ "WHERE codice_fiscale_atleta ='RSSLRT03A01H703I';";
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					int accessi = res.getInt("accessi");
					System.out.println(accessi);
					tro = res.next();
				}
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query13() {
			try {
				System.out.println("Visualizzare il numero di corsi a carico di un istruttore:\n\n");
				
				String query = "SELECT corso_a_carico\r\n"
								+ "FROM Istruttore AS I,Dipendente AS D\r\n"
								+ "WHERE I.codice_fiscale_istruttore= 'FRNSRA01R60A509X' AND D.codice_fiscale_dipendente='FRNSRA01R60A509X';";
				
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					int corso_a_carico = res.getInt("corso_a_carico");
					System.out.println(corso_a_carico);
					tro = res.next();
				}
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query14() {
			try {
				System.out.println("Ordinare gli abbonamenti di tutti gli iscritti per data di scadenza:\n\n");
				
				String query = "SELECT A.nome,A.cognome,S.data_fine,A.email\r\n"
								+ "FROM Sottoscrive AS S,Atleta AS A\r\n"
								+ "WHERE S.codice_fiscale_atleta=A.codice_fiscale_atleta\r\n"
								+ "ORDER BY data_fine ASC;";
				
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					String nome = res.getString("nome");
					String cognome = res.getString("cognome");
					Date data_fine = res.getDate("data_fine");
					System.out.println(nome+ " " + cognome + " " + data_fine);
					tro = res.next();
				}
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}


		public void query15() {
			try {
				System.out.println("Selezionare nome e cognome dei Personal Trainer che si sono occupati di almeno 3 schede:\n\n");
				
				String query = "SELECT D.nome,D.cognome\r\n"
						+ "FROM Dipendente AS D,Personal_trainer AS PT,Scheda AS S\r\n"
						+ "WHERE PT.codice_fiscale_pt=S.codice_fiscale_pt AND D.codice_fiscale_dipendente=PT.codice_fiscale_pt\r\n"
						+ "HAVING COUNT(S.codice_scheda) >= 3;";
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					String nome = res.getString("nome");
					String cognome = res.getString("cognome");
					System.out.println(nome + " " + cognome);
					tro = res.next();
				}
			}

			catch(Exception e) {
				System.err.print(e.getMessage());
			}
		}
		
		public void query16() {
			try {
				System.out.println("Selezionare nome e cognome degli iscritti che frequentano almeno un corso:");
				
				String query = "SELECT A.nome,A.cognome\r\n"
								+ "FROM Atleta AS A ,Frequenta AS F\r\n"
								+ "WHERE A.codice_fiscale_atleta=F.codice_fiscale_atleta;";
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					String nome = res.getString("nome");
					String cognome = res.getString("cognome");
					System.out.println(nome + " " + cognome);
					tro = res.next();
				}
				
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
	}
		
		public void query17() {
			try {
				System.out.println("Selezionare l'email di tutti gli atleti che non hanno sottoscritto un determinato tipo di abbonamento");
				
				String query = "SELECT A.email\r\n"
						+ "FROM Atleta AS A\r\n"
						+ "WHERE NOT EXISTS(\r\n"
							+ "	SELECT Ab.nome\r\n"
							+ " FROM Abbonamento AS Ab,Sottoscrive AS S\r\n"
							+ " WHERE Ab.nome=S.nome AND S.codice_fiscale_atleta=A.codice_fiscale_atleta AND Ab.tipo='misto'\r\n);";
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					String email = res.getString("email");
					System.out.println(email);
					tro = res.next();
				}
				
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
	}
		
		public void query18() {
			try {
				System.out.println("Selezionare l'email di tutti gli atleti che hanno una determinata scheda");
				
				String query = "SELECT A.email\r\n"
						+ "FROM Atleta AS A\r\n"
						+ "WHERE NOT EXISTS(\r\n"
							+ "	SELECT S.codice_scheda\r\n"
							+ " FROM Scheda AS S,Richiede AS R\r\n"
							+ " WHERE S.codice_scheda='IT490' AND R.codice_fiscale_atleta=A.codice_fiscale_atleta\r\n);";
				PreparedStatement cmd = con.prepareStatement(query);
				ResultSet res = cmd.executeQuery();
				boolean tro = res.next();
				while(tro) {
					String email = res.getString("email");
					System.out.println(email);
					tro = res.next();
				}
				
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
			}
	}

	private Connection con;
}