package unitTests;

import org.example.LongTermParkingLot;
import org.example.PremiumLot;
import org.example.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LongTermLotTester {
    LongTermParkingLot uut;
    Ticket ticket;

    @BeforeEach
    public void setUp() {
        uut = new LongTermParkingLot();
        ticket = mock(Ticket.class);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,29,0",
            "0,0,30,0",
            "0,0,31,2",
            "0,2,0,4",
            "0,1,1,4",
            "0,7,0,14",
            "0,7,1,15",
            "1,0,0,15",
            "0,8,0,15",
            "7,0,0,105",
            "7,0,1,107"
    })
    public void TestRates(int days, int hours, int minutes, int expectedResult) {
        when(ticket.getDays()).thenReturn(days);
        when(ticket.getHours()).thenReturn(hours);
        when(ticket.getMinutes()).thenReturn(minutes);

        int actualResult = uut.calculateFee(ticket);

        assertEquals(expectedResult, actualResult);
    }
}
