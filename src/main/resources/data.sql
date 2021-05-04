

INSERT INTO Nutzer(EMail, Geburtsdatum, Nachname, Vorname, Passwort)
VALUES('nutzer1@hhu.de', '1999-01-01','Mustermann1','Max1', 'Passwort1'),
      ('nutzer2@hhu.de', '1999-02-02','Doe2','John2', 'Passwort2'),
      ('nutzer3@hhu.de', '1999-03-03','Mustermann3','Max3', 'Passwort3'),
      ('nutzer4@hhu.de', '1999-04-04','Doe4','Jane4', 'Passwort4'),
      ('nutzer5@hhu.de', '1999-05-05','Doe5','John5', 'Passwort5'),
      ('nutzer6@hhu.de', '1999-06-06','Musk','Jane', 'Passwort6'),
      ('nutzer7@hhu.de', '1999-07-07','Musk','Max', 'Passwort7');

INSERT INTO Bibliothekar(EMail,Telefonnummer)
VALUES('nutzer1@hhu.de', '004911024025'),
      ('nutzer2@hhu.de', '004911024026'),
      ('nutzer3@hhu.de', '004911024027');

INSERT INTO Adresse(Stadt, Postleitzahl, Strasse, Hausnummer)
VALUES('Duesseldorf', 40225, 'UniversitaetStrasse', 1),
      ('Koeln', 50667, 'TunisStrasse', 23),
      ('Berlin', 10115, 'InvalidenStrasse', 10),
	  ('Muenchen', 80331, 'Ledererstrasse', 12);

INSERT INTO Kunde(EMail, Guthaben, Jahresbeitrag, AdresseID)
VALUES('nutzer4@hhu.de', 34.9, true, (SELECT ID FROM Adresse WHERE Stadt = 'Duesseldorf' AND Postleitzahl = 40225 AND Strasse = 'UniversitaetStrasse' AND Hausnummer = 1)),
      ('nutzer5@hhu.de', 40, false, (SELECT ID FROM Adresse WHERE Stadt = 'Koeln' AND Postleitzahl = 50667 AND Strasse = 'TunisStrasse' AND Hausnummer = 23)),
      ('nutzer6@hhu.de', 49.99, false, (SELECT ID FROM Adresse WHERE  Stadt = 'Berlin' AND Postleitzahl = 10115 AND Strasse = 'InvalidenStrasse' AND Hausnummer = 10)),
      ('nutzer7@hhu.de', 29.99, true, (SELECT ID FROM Adresse WHERE Stadt = 'Berlin' AND Postleitzahl = 10115 AND Strasse = 'InvalidenStrasse' AND Hausnummer = 10));

INSERT INTO Medium(Name)
VALUES('Hardcover'),
      ('Softcover'),
	  ('DVD'),
	  ('CD');

INSERT INTO Artikel(ISBNNummer, Erscheinungsdatum, Beschreibung, Coverbild, Bezeichnung, Medium)
VALUES('978-3-44215-147-3', '2010-01-01', 'Artikel von 2010',null,'Artikel1','Hardcover'),
      ('978-3-44215-147-4', '2011-03-03', 'Artikel von 2011',null,'Artikel2','Softcover'),
      ('978-3-44215-147-5', '2012-02-02', 'Artikel von 2012',null,'Artikel3','Hardcover'),
      ('978-3-44215-147-6', '2014-10-03', 'Artikel von 2014',null,'Artikel4','Hardcover'),
      ('978-3-44215-147-7', '2013-03-10', 'Artikel von 2013',null,'Artikel5','Softcover'),
	  ('978-3-44215-147-8', '2015-04-11', 'Artikel von 2015',null,'Artikel6','DVD');

INSERT INTO Standort(Etage, Regalnr)
VALUES(3,31),
      (2,21),
      (1,11),
      (2,22),
      (3,32),
	  (4,41);

INSERT INTO Exemplar(Anschaffungspreis, StandortID, ISBNNummer)
VALUES(20, (SELECT ID FROM Standort WHERE Etage = 3 AND Regalnr = 31),'978-3-44215-147-3'),
	  (25, (SELECT ID FROM Standort WHERE Etage = 3 AND Regalnr = 31),'978-3-44215-147-3'),
      (19.99, (SELECT ID FROM Standort WHERE Etage = 3 AND Regalnr = 32),'978-3-44215-147-7'),
      (30.01, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 21 ),'978-3-44215-147-4'),
      (45.05, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 22),'978-3-44215-147-5'),
      (24.9, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 22),'978-3-44215-147-6'),
      (29.99, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 21),'978-3-44215-147-4'),
      (24.9, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 21),'978-3-44215-147-6'),
      (14.9, (SELECT ID FROM Standort WHERE Etage = 1 AND Regalnr = 11), '978-3-44215-147-7'),
      (15, (SELECT ID FROM Standort WHERE Etage = 1 AND Regalnr = 11),'978-3-44215-147-7'),
      (24.95, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 22),'978-3-44215-147-6'),
      (25, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 21),'978-3-44215-147-6'),
      (24.95, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 21),'978-3-44215-147-6'),
      (24.59, (SELECT ID FROM Standort WHERE Etage = 2 AND Regalnr = 22),'978-3-44215-147-6');

INSERT INTO Ausleihe(Beginn, Ende, Zurueckgabe, KundeEMail, ExemplarID)
VALUES('2021-01-01 12:00:00', '2021-03-01 12:00:00',false,'nutzer4@hhu.de',1),
	   ('2020-12-01 10:00:00', '2021-03-23 10:00:00',false,'nutzer5@hhu.de',2),
	   ('2021-02-01 11:00:00', '2021-03-21 11:00:00',false,'nutzer6@hhu.de',3),
	   ('2020-11-19 13:00:00', '2021-03-01 13:00:00',true,'nutzer7@hhu.de',4),
	   ('2020-12-20 15:00:00', '2021-03-12 15:00:00',false,'nutzer4@hhu.de',6),
	   ('2020-11-28 09:00:00', '2021-02-28 09:00:00',true,'nutzer7@hhu.de',5);

INSERT INTO Genre(Name)
VALUES('Mathematik'),
      ('Informatik'),
      ('Physik'),
      ('Kriminalroman'),
      ('ScienceFiction'),
	  ('Geschichte');

INSERT INTO Autor(Vorname, Nachname)
VALUES('Autor1', 'Autor1Nach'),
      ('Autor2', 'Autor2Nach'),
      ('Autor3', 'Autor3Nach'),
      ('Autor4', 'Autor4Nach'),
      ('Autor5', 'Autor5Nach'),
	  ('Autor6', 'Autor6Nach');

INSERT INTO VerfasstVon(ISBNNummer, AutorID)
VALUES('978-3-44215-147-3', (SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor1' AND Autor.Nachname = 'Autor1Nach')),
      ('978-3-44215-147-4',(SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor5' AND Autor.Nachname = 'Autor5Nach')),
	  ('978-3-44215-147-3',(SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor2' AND Autor.Nachname = 'Autor2Nach')),
      ('978-3-44215-147-3',(SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor4' AND Autor.Nachname = 'Autor4Nach')),
      ('978-3-44215-147-5',(SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor4' AND Autor.Nachname = 'Autor4Nach')),
      ('978-3-44215-147-6',(SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor3' AND Autor.Nachname = 'Autor3Nach')),
      ('978-3-44215-147-7', (SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor3' AND Autor.Nachname = 'Autor3Nach')),
      ('978-3-44215-147-7',(SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor5' AND Autor.Nachname = 'Autor5Nach')),
      ('978-3-44215-147-7',(SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor1' AND Autor.Nachname = 'Autor1Nach')),
      ('978-3-44215-147-7',(SELECT ID FROM Autor WHERE Autor.Vorname = 'Autor2' AND Autor.Nachname = 'Autor2Nach'));

INSERT INTO GehoertZu(Genre, ISBNNummer)
VALUES('Mathematik', '978-3-44215-147-3'),
      ('Physik', '978-3-44215-147-3'),
      ('Mathematik', '978-3-44215-147-4'),
      ('Physik', '978-3-44215-147-5'),
      ('Kriminalroman', '978-3-44215-147-6'),
      ('Kriminalroman', '978-3-44215-147-7'),
      ('ScienceFiction', '978-3-44215-147-7');

INSERT INTO Empfehlen(EmpfehlungArtikel, EmpfohleneArtikel)
VALUES('978-3-44215-147-3', '978-3-44215-147-4'),
       ('978-3-44215-147-5', '978-3-44215-147-3'),
       ('978-3-44215-147-4', '978-3-44215-147-3'),
       ('978-3-44215-147-4', '978-3-44215-147-5'),
       ('978-3-44215-147-6', '978-3-44215-147-7'),
       ('978-3-44215-147-3', '978-3-44215-147-6');
