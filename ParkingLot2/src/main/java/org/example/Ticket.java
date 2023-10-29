package org.example;

public interface Ticket {
    public int getDays();
    public int getHours();
    public int getMinutes();
    public void setEntryTime(String entryTime);
    public void setExitTime(String exitTime);
}
