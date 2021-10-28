select g.name,
ro.roomsNumber,
r.checkin,r.checkout 
from guest g 
	join reservations r
	 on g.guestID=r.guestID
join roomsreservations rr 
	on r.reservationID=rr.reservationID
join rooms ro
	on rr.roomID=ro.roomsID
	 where r.checkin between '2023/07/01' and '2023/07/31';
#2

select g.name,ro.roomsNumber,r.checkin,r.checkout 
from guest g 
join reservations r
on g.guestID=r.guestID
join roomsreservations rr 
on r.reservationID=rr.reservationID
join rooms ro on ro.roomsID=rr.roomID
join roomAmenities ra on ra.roomID=ro.roomsID
join amenities a on a.amenitiesID=ra.amenitiesID
where a.name='Jacuzzi';

#3

select g.name, rr.reservationID, ro.roomsNumber, r.checkin, rr.adults, rr.children 
from guest g
join reservations r
on g.guestID = r.guestID
join roomsreservations rr
on r.reservationiD = rr.reservationID
join rooms ro on ro.roomsid=rr.roomid
where g.name='Mohamed Derie';

#4

select ro.roomsNumber,r.reservationID,rt.baseprice
from reservations r 
join roomsreservations rr on r.reservationID=rr.reservationID
join rooms ro on ro.roomsID=rr.roomID
join roomtype rt on rt.typeid= ro.typeid;

# 5

select r.roomsNumber, r.maxOccupancy, g.name , re.checkin
from rooms r 
join roomsReservations rr on r.roomsid = rr.roomid
join reservations re on re.reservationid = rr.reservationid
join guest g on g.guestid = re.guestid
where re.checkin between "2023-04-01" and "2023-04-30" 
and r.maxOccupancy >= 3;

# 6

select g.name, count(rr.reservationid) numofReservation 
from guest g
join reservations r
on g.guestid = r.guestid
join roomsreservations rr
on r.reservationid = rr.reservationid
group by g.name
order by numofReservation desc;


#7  
select g.name, g.address, g.phone
from guest g
where g.phone ='612-501-9480';

select * 
from roomsreservations where roomId = 9;