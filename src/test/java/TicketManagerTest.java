import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repository = new TicketRepository();

    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(11, 1000, "ATL", "DXB", 300);
    Ticket ticket2 = new Ticket(12, 2000, "PEK", "HKG", 200);
    Ticket ticket3 = new Ticket(13, 1500, "ATL", "HKG", 120);
    Ticket ticket4 = new Ticket(14, 500, "PEK", "HKG", 300);
    Ticket ticket5 = new Ticket(15, 700, "PEK", "HKG", 240);
    Ticket ticket6 = new Ticket(16, 2400, "PEK", "DXB", 300);
    Ticket ticket7 = new Ticket(17, 400, "ATL", "DXB", 180);
    Ticket ticket8 = new Ticket(18, 13000, "ATL", "DXB", 400);

    @Test
    public void shouldFindAllWithEmptyRepository() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("PEK", "HKG");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindAll() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);

        Ticket[] expected = {ticket7, ticket1, ticket8};
        Ticket[] actual = manager.findAll("ATL", "DXB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllEmptySearchReq() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);

        Ticket[] expected = {ticket7, ticket4, ticket5, ticket1, ticket3, ticket2, ticket6, ticket8};
        Ticket[] actual = manager.findAll("", "");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllNonexistentFrom() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DXB", "HKG");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllNonexistentTo() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ATL", "PEK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllEmptyFrom() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);

        Ticket[] expected = {ticket4, ticket5, ticket3, ticket2};
        Ticket[] actual = manager.findAll("", "HKG");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllEmptyTo() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);

        Ticket[] expected = {ticket4, ticket5, ticket2, ticket6};
        Ticket[] actual = manager.findAll("PEK", "");

        Assertions.assertArrayEquals(expected, actual);
    }
}
