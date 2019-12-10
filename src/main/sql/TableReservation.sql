CREATE DATABASE MEETINGROOM;

CREATE TABLE Salle(
id int NOT NULL,
nom varchar(50) NOT NULL,
constraint pk_idSalle Primary key (id)
);

CREATE TABLE Utilisateur(
id int NOT NULL,
nom varchar(50) NOT NULL,
prenom varchar(50) NOT NULL, 
motdepasse varchar(50) NULL,
tel int NOT NULL,
email varchar(50) NOT NULL,
constraint pk_idUtilisateur Primary key (id)
);

CREATE TABLE Reservation(
id int NOT NULL,
durée int NOT NULL,
dateDebutReserv Date NOT NULL,
dateFinReserv Date  NOT NULL,
salleID int NOT NULL,
utilisateurID int NOT NULL, 
constraint pk_ID Primary key (id),
constraint FK_iSalleReserv FOREIGN KEY (salleID) references Salle(id), 
constraint FK_idutilisateurReserv FOREIGN KEY (utilisateurID) references Utilisateur(id) 
);