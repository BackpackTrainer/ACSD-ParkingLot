package org.example;

public class LongTermLot implements ParkingLot {
    @Override
    public int calculateFee(Ticket ticket) {
        int minutes = ticket.getMinutes();
        int hours = ticket.getHours();
        int days= ticket.getDays();
        int total = 0;
        if (minutes <= 30 && hours == 0 && days == 0) {
        } else {
            if (minutes > 0 ){
                total+=2;
            }
            total+=hours*2;
            total = Math.min(total, 15);
            total+=days*15;
        }
            return total;
    }

}
