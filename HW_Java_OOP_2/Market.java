import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Market implements MarketBehavior, QueueBehavior {
    private List<Actor> queue;


    public Market(List<Actor> queue) {
        this.queue = new ArrayList<>(queue);
    }

    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            actor.setMakeOrder(true);
            actor.setTicketNumber(QueueTicketGenerator.generateTicket());
            System.out.println(actor.getName() + " сделал свой заказ. Номер заказа: " + actor.getTicketNumber() + ".");
        }
        System.out.println();

    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            actor.setTakeOrder(true);
            System.out.println(actor.getName() + " забрал свой заказ " + actor.getTicketNumber()+ ".");
        }
        System.out.println();
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> realeasedActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder) {
                realeasedActors.add(actor);
//                System.out.println(actor.getName() + " вышел из очереди.");
            }
        }
        releaseFromMarket(realeasedActors);
    }

    @Override
    public void acceptToMarket(Actor actor) {
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина.");
            queue.remove(actor);
        }
    }

    @Override
    public void update() throws InterruptedException {
        Runnable task = ()-> {
                takeOrders();
                giveOrders();
                releaseFromQueue();
            System.out.println("\n--- Ожидание новых посетителей!---\n");
        };
        Thread thread = new Thread(task);
        Random random = new Random();
        thread.start();
        Thread.sleep(random.nextInt(3000,7000));
    }

    public List<Actor> getQueue() {
        return queue;
    }

    public void setQueue(List<Actor> queue) {
        this.queue = queue;
    }

}
