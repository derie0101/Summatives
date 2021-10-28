drop database if exists GuessGame;
create database GuessGame ;
use  GuessGame; 

create table Game(
GameId int primary key not null auto_increment,
TargetNumber varchar(50),
StatusofGame int not null);

create table Round(
RoundId int primary key not null auto_increment,
GameId int not null,
UsersGuess varchar(50),
FinalResults varchar(50),
RoundTime Datetime,
Foreign Key (GameID) references Game(GameId));



-- GameId 
-- GameStatus
-- Number of guesses 
-- exact and partial guesses
-- time stamp 