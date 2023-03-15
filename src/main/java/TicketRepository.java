public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public TicketRepository() {
    }

    public void addTicket(Ticket newTicket) {
        if (findById(newTicket.id) == null) {
            Ticket[] tmp = new Ticket[tickets.length + 1];
            for (int i = 0; i < tickets.length; i++) {
                tmp[i] = tickets[i];
            }
            tmp[tmp.length - 1] = newTicket;
            tickets = tmp;
            return;
        }
        throw new AlreadyExistsException(
                "Element with id: " + newTicket.id + " already exists"
        );
    }

    public Ticket[] allTickets() {
        Ticket[] all = getTickets();
        return all;
    }

    public Ticket findById(int id) {
        for (Ticket product : tickets) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int index = 0;
            for (Ticket ticket : tickets) {
                if (ticket.id != id) {
                    tmp[index] = ticket;
                    index++;
                }
                tickets = tmp;
            }
            return;
        }
        throw new NotFoundException(
                "Element with id:" + id + "not found"
        );
    }


    public Ticket[] getTickets() {
        return tickets;
    }
}
