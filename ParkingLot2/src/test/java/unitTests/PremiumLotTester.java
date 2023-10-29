package unitTests;

import org.example.PremiumLot;
import org.example.Ticket;
import org.example.TicketImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PremiumLotTester {
    PremiumLot uut;
    Ticket ticket;

    @BeforeEach
    public void setUp() {
        uut = new PremiumLot();
        ticket = mock(Ticket.class);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1,0,4",
            "0,0,1,4",
            "0,0,20,4",
            "0,2,0,8",
            "0,1,1,8",
            "1,0,0,27",
            "0,8,0,27",
            "7,0,0,162",
            "8,0,0,189",
            "14,0,0,324",
            "6,0,1,162"
    })
    public void TestRates(int days, int hours, int minutes, int expectedResult) {
        when(ticket.getDays()).thenReturn(days);
        when(ticket.getHours()).thenReturn(hours);
        when(ticket.getMinutes()).thenReturn(minutes);

        int actualResult = uut.calculateFee(ticket);

        assertEquals(expectedResult, actualResult);
    }
}
