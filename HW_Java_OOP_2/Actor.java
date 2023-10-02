public abstract class Actor implements ActorBehavior{

    protected String name;
    protected String ticketNumber;

    protected boolean isMakeOrder;

    protected boolean isTakeOrder;
    public Actor(String name) {
        this.name = name;
    }

    abstract String getName();

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public void setTakeOrder(boolean takeOrder) {
        isTakeOrder = takeOrder;
    }
}
