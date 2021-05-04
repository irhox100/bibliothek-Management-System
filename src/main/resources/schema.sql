
DROP TABLE IF EXISTS Empfehlen;
DROP TABLE IF EXISTS GehoertZu;
DROP TABLE IF EXISTS VerfasstVon;
DROP TABLE IF EXISTS Ausleihe;
DROP TABLE IF EXISTS Exemplar;
DROP TABLE IF EXISTS Artikel;
DROP TABLE IF EXISTS Kunde;
DROP TABLE IF EXISTS Bibliothekar;
DROP TABLE IF EXISTS Genre;
DROP TABLE IF EXISTS Medium;
DROP TABLE IF EXISTS Standort;
DROP TABLE IF EXISTS Autor;
DROP TABLE IF EXISTS Adresse;
DROP TABLE IF EXISTS Nutzer;

CREATE TABLE IF NOT EXISTS Nutzer
(
    EMail VARCHAR(100) NOT NULL PRIMARY KEY
        CHECK (EMail LIKE '%@%.%'),
    Geburtsdatum DATE NOT NULL
        CHECK(Geburtsdatum LIKE '____-__-__'),
    Nachname VARCHAR(100) NOT NULL,
    Vorname VARCHAR(100) NOT NULL,
    Passwort VARCHAR(100) NOT NULL
        CHECK (length(Passwort) >= 4)
);

CREATE TABLE IF NOT EXISTS Adresse
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    Stadt VARCHAR(100) NOT NULL,
    Postleitzahl INTEGER NOT NULL CHECK(Postleitzahl > 0),
    Strasse VARCHAR(100) NOT NULL,
    Hausnummer INTEGER NOT NULL CHECK(Hausnummer > 0)
);

CREATE TABLE IF NOT EXISTS Autor
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    Vorname VARCHAR(100) NOT NULL,
    Nachname VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Standort
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    Etage INTEGER NOT NULL CHECK(Etage >= 0),
    Regalnr INTEGER NOT NULL CHECK(Regalnr > 0)
);



CREATE TABLE IF NOT EXISTS Medium
(
    Name VARCHAR(100) NOT NULL PRIMARY KEY
        CHECK ( Name IN ('Hardcover', 'Softcover', 'DVD', 'CD'))
);

CREATE TABLE IF NOT EXISTS Genre
(
    Name VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Bibliothekar
(
    EMail VARCHAR(100) NOT NULL PRIMARY KEY,
    Telefonnummer VARCHAR(100) NOT NULL UNIQUE
        CHECK (Telefonnummer LIKE '0049%'),
    FOREIGN KEY (EMail) REFERENCES Nutzer(EMail) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Kunde
(
    EMail VARCHAR(100) NOT NULL PRIMARY KEY,
    Guthaben INTEGER NOT NULL
        CHECK(Guthaben LIKE ROUND(Guthaben,2) OR (Guthaben LIKE Guthaben AND length(Guthaben)<=length(ROUND(Guthaben,2))) AND Guthaben >= 0),
    Jahresbeitrag BOOLEAN
        CHECK(Jahresbeitrag IN (true,false)),
    AdresseID INTEGER NOT NULL,
    FOREIGN KEY (AdresseID) REFERENCES Adresse(ID),
    FOREIGN KEY (EMail) REFERENCES Nutzer(Email) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Artikel
(
    ISBNNummer VARCHAR(100) NOT NULL PRIMARY KEY,
    Erscheinungsdatum DATE NOT NULL,
    Beschreibung TEXT NOT NULL,
    Coverbild BLOB,
    Bezeichnung VARCHAR(100) NOT NULL,
    Medium VARCHAR(100) NOT NULL,
    FOREIGN KEY(Medium) REFERENCES Medium(Name) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Exemplar
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    Anschaffungspreis INTEGER NOT NULL
        CHECK(Anschaffungspreis LIKE ROUND(Anschaffungspreis,2) OR
              (Anschaffungspreis LIKE Anschaffungspreis AND length(Anschaffungspreis)<=length(ROUND(Anschaffungspreis,2))) AND Anschaffungspreis > 0),
    StandortID INTEGER NOT NULL,
    ISBNNummer VARCHAR(100) NOT NULL,
    FOREIGN KEY (StandortID) REFERENCES Standort(ID),
    FOREIGN KEY (ISBNNummer) REFERENCES Artikel(ISBNNummer) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Ausleihe
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    Beginn DATETIME NOT NULL
        CHECK(Beginn LIKE '____-__-__ __:__:__'),
    Ende DATETIME NOT NULL
        CHECK(Ende LIKE '____-__-__ __:__:__'),
    Zurueckgabe BOOLEAN NOT NULL
        CHECK(Zurueckgabe IN (true,false)),
    KundeEMail VARCHAR(100) NOT NULL,
    ExemplarID INTEGER NOT NULL,
    FOREIGN KEY (KundeEMail) REFERENCES Kunde(EMail) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (ExemplarID) REFERENCES Exemplar(ID)
);

CREATE TABLE IF NOT EXISTS VerfasstVon
(
    ISBNNummer VARCHAR(100) NOT NULL,
    AutorID INTEGER NOT NULL,
    PRIMARY KEY(ISBNNummer, AutorID),
    FOREIGN KEY (ISBNNummer) REFERENCES Artikel(ISBNNummer) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (AutorID) REFERENCES Autor(ID)
);

CREATE TABLE IF NOT EXISTS GehoertZu
(
    Genre VARCHAR(100) NOT NULL,
    ISBNNummer VARCHAR(100) NOT NULL,
    PRIMARY KEY(Genre, ISBNNummer),
    FOREIGN KEY(Genre) REFERENCES Genre(Name) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(ISBNNummer) REFERENCES Artikel(ISBNNummer) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Empfehlen
(
    EmpfehlungArtikel VARCHAR(100) NOT NULL,
    EmpfohleneArtikel VARCHAR(100) NOT NULL,
    PRIMARY KEY(EmpfehlungArtikel, EmpfohleneArtikel),
    FOREIGN KEY (EmpfehlungArtikel) REFERENCES Artikel(ISBNNummer) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (EmpfohleneArtikel) REFERENCES Artikel(ISBNNummer) ON UPDATE CASCADE ON DELETE CASCADE
);















