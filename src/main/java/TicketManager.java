import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void addTicket(Ticket newTicket) {
        repository.addTicket(newTicket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        int index = 0;
        for (Ticket ticket : repository.allTickets()) {
            if (ticket.matches(from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                if (result.length == 0) {
                    tmp[index] = ticket;
                } else {
                    for (int i = 0; i < tmp.length - 1; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                }
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}
