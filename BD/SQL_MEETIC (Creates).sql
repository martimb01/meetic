/************************************************************
*	Grupo: 3    |  Curso: «Informática de Gestão»
*  	UC: «Base de Dados»
*   
*	Pojeto: «Meetic»
*   
*  	Nome: «Afonso Faustino» (20201027)
*  	Nome: «Martim Bento» (20200488)
*  	Nome: «Vasco Fidanza» (20200941)
*  	
*  	
************************************************************/

-- instrucoes SQL para definir o nome da Base de Dados no MySQL workbench
Create database Meetic;
use Meetic;


/************************************************************
*  Lista de Entidades Informaconais Primarias
************************************************************/
create table Event_type (et_Id int not null auto_increment,
						 et_Category varchar(20) not null,
                         primary key (et_Id)
);

create table Difficulty (di_Id int not null auto_increment,
                         di_AmountPoints int not null,
                         di_name varchar(10) not null,
                         primary key(di_Id)
);

create table Organizer (or_Id int not null auto_increment,
						or_PhoneNum CHAR(14),
						or_Email varchar(40) not null,
                        or_FirstName varchar(20) not null,
                        or_LastName varchar(30) not null,
                        or_DateOfBirth date not null,
                        or_Gender varchar (1) not null, 
                        primary key (or_Id)
);


create table Auditor (au_Id int not null auto_increment,
					  au_PhoneNum CHAR(14),
					  au_Email varchar(40) not null,
                      au_FirstName varchar(20) not null,
                      au_LastName varchar(30) not null,
                      au_DateOfBirth date not null,
                      au_Gender varchar(1) not null,
                      primary key (au_Id)
);


CREATE TABLE User (us_Id INT NOT NULL AUTO_INCREMENT,
				   us_FirstName VARCHAR(20) NOT NULL,
				   us_LastName VARCHAR(20) NOT NULL,
				   us_DateOfBirth DATE NOT NULL,
				   us_Cc CHAR(12) NOT NULL,
				   us_Gender CHAR(1) NOT NULL,
				   us_Adress VARCHAR(60) NOT NULL,
				   us_Email VARCHAR(30) NOT NULL,
                   us_TotalPoints INT DEFAULT 0,
                   us_PhoneNum CHAR(14) NOT NULL,
				   PRIMARY KEY (us_Id),
                   CHECK ((us_TotalPoints) >= 0) -- RI10
);


create table PostalCode (po_Id int not null auto_increment,
						 po_Id_4d int not null,
                         po_Id_3d int not null,
                         po_Locality varchar(30) not null,
                         po_City varchar(30) default 0,
                         po_Parish varchar(30) default 0,
                         primary key (po_id),
                         check (length(po_Id_4d) = 4), 
						 check (length(po_Id_3d) = 3));
                         


create table Gifts (gi_Id int not null auto_increment,
                    gi_Name varchar(20) not null,
                    gi_Price int not null,
                    gi_ExpirationDat date not null,
					primary key (gi_Id),            
                    CHECK ((gi_Price) >= 0)); -- RI10


create table Event_Status (es_Id int not null auto_increment,
						   es_Status varchar(15) not null, 
                           primary key (es_Id)
);


/************************************************************
*  Lista de Entidades Informaconais com FK
************************************************************/

CREATE TABLE Lives (li_us_Id INT NOT NULL,
					li_po_Id INT NOT NULL,
                    li_Date DATETIME NOT NULL,
                    PRIMARY KEY (li_us_Id, li_po_Id),
                    FOREIGN KEY (li_us_Id) REFERENCES User (us_Id),
                    FOREIGN KEY (li_po_Id) REFERENCES PostalCode (po_Id));


create table Event (ev_Id int not null auto_increment, 
					ev_Capacity INT NOT NULL,
					ev_Name varchar(100) not null,
                    ev_StartDate datetime not null,
                    ev_EndDate datetime not null,
                    ev_Description varchar(260),
                    ev_EvType_Id int not null,
                    ev_or_Id int not null,
                    ev_di_Id INT NOT NULL,
                    primary key (ev_Id),
					FOREIGN KEY (ev_di_Id) REFERENCES Difficulty (di_Id),
                    FOREIGN KEY (ev_EvType_Id) REFERENCES Event_type(et_Id),
                    FOREIGN KEY (ev_or_Id) REFERENCES Organizer (or_Id),
                    CHECK ((ev_Capacity) >= 1),
                    CHECK ((ev_StartDate < ev_EndDate)) -- RI14
);


CREATE TABLE Place (pa_id int not null auto_increment,
					pa_po_Id INT NOT NULL,
					pa_name varchar (100) not null,
                    pa_ev_id int not null,
                    FOREIGN KEY (pa_po_Id) REFERENCES PostalCode (po_Id),
                    FOREIGN KEY (pa_ev_id) REFERENCES Event (ev_Id),
                    primary key (pa_id)
);


CREATE TABLE Enrolls (en_Id INT AUTO_INCREMENT,
					  en_ev_Id int not null,
                      en_or_Id int not null,
					  en_us_Id int not null,
                      en_Date datetime not null,
					  en_participation boolean not null,
					  primary key(en_Id),
                      foreign key (en_ev_Id) references Event (ev_Id),
					  foreign key (en_us_Id) references User (us_Id)
					  ON DELETE NO ACTION ON UPDATE NO ACTION
);

/************************************************************
*  Lista de Entidades de Associacao 
************************************************************/

create table Gives (gv_or_Id int not null,
                    gv_gi_Id int not null,
                    gv_Date datetime not null,
                    primary key (gv_or_Id, gv_gi_Id),
                    foreign key (gv_or_Id) references Organizer (or_Id), 
                    foreign key (gv_gi_Id) references Gifts (gi_Id) 
					ON DELETE NO ACTION ON UPDATE NO ACTION
);

                    
create table Redeems (re_us_Id int not null,
                      re_gi_Id int not null,
                      re_Date datetime not null,
                      primary key (re_us_Id, re_gi_Id),
                      foreign key (re_us_Id) references User (us_Id), 
                      foreign key (re_gi_Id) references Gifts (gi_Id) 
					  ON DELETE NO ACTION ON UPDATE NO ACTION
); 


create table Manages (ma_Id int not null auto_increment,
					  ma_Date datetime not null,
				      ma_ev_Id int not null,
					  ma_es_Id int not null default 1,
					  ma_au_Id int, 
					  primary key (ma_Id),
					  foreign key (ma_ev_Id) references Event (ev_Id),
					  foreign key (ma_au_Id) references Auditor (au_Id),
					  foreign key (ma_es_Id) references Event_Status (es_Id)
                      ON DELETE NO ACTION ON UPDATE NO ACTION
);


create table Approves (ap_gi_Id int not null,
					   ap_au_Id int not null,
                       foreign key (ap_gi_Id) references Gifts (gi_Id),
                       foreign key (ap_au_Id) references Auditor (au_Id)
);


