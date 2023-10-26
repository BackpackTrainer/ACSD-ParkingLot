package longTermLot;

import org.example.LongTermLot;
import org.example.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LongTermLotTests {
    Ticket ticket;
    LongTermLot uut;
    @BeforeEach
    public void setUp(){
        ticket = mock(Ticket.class);
        uut = new LongTermLot();
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0, 0", "15, 0, 0, 0", "30, 0, 0, 0", "31, 0, 0, 2", "0, 1, 0, 2", "1, 1, 0, 4", "45, 7, 0, 15", "0, 8, 0, 15", "0, 0, 5, 75", "59, 4, 6, 100"})
    public void lotReturnsCorrectFee(int minutes, int hours, int days, int expectedResult){
        when(ticket.getMinutes()).thenReturn(minutes);
        when(ticket.getHours()).thenReturn(hours);
        when(ticket.getDays()).thenReturn(days);
        int actualResult = uut.calculateFee(ticket);
        assertEquals(expectedResult, actualResult);
    }
}

/*
MINUTES|HOURS|DAYS|expectedPrice
*0, 0, 0, 0*
15, 0, 0, 0
30, 0, 0, 0
31, 0, 0, 2
0, 2, 0, 4
59, 3, 0, 8
1, 1, 0, 4
45, 7, 0, 15
0, 0, 5, 75
59, 4, 6, 100

 */
