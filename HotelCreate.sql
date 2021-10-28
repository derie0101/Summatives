drop database if exists Hotel;
create database Hotel;
use Hotel; 


create table guest(
guestID int primary key auto_increment,
name varchar(30) not null,
address varchar(30) not null, 
city varchar(30) not null,
state varchar(30) not null,
zip varchar(10),
phone varchar(30) not null);


create table Roomtype (
typeId Int primary key not null auto_increment,
name varchar(30),
standardOccupancy int,
maxOccupancy int,
extraPerson numeric(6,2),
basePrice numeric(6,2)
);


create table Rooms(
RoomsId int primary key auto_increment,
RoomsNumber varchar(30),
Floor Varchar(30),
ADA varchar(30),
typeId int,
constraint fk_rooms_type Foreign key (typeId) references Roomtype(typeId)
);

create table Reservations(
ReservationId int primary key not null auto_increment,
CheckIn Date,
CheckOut Date,
guestId int,
constraint fk_reservations_guest foreign key (guestID) references guest(guestID)
);

create table RoomsReservations(
adults int,
children int,
reservationId int,
roomId int,
primary key(roomId, reservationId),
constraint fk_roomsreservations_reservations foreign key (ReservationId) references Reservations(ReservationId),
constraint fk_roomsreservations_rooms foreign key (roomId) references Rooms(RoomsId)
);
 
create table Amenities(
AmenitiesId int primary key auto_increment,
Name varchar(30),
Price numeric(5,2)
);

create table RoomAmenities(
roomId int,
amenitiesId int,
constraint fk_roomamenities_amenities foreign key(AmenitiesId) references Amenities(AmenitiesId),
constraint fk_roomamenities_rooms foreign key(roomId) references Rooms(RoomsId));