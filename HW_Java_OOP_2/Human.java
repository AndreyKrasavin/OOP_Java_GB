import java.io.FileNotFoundException;
import java.io.FileReader;

public class Human extends Actor{

    public Human(String name) {
        super(name);
    }

    @Override
    String getName() {
        return super.name;
    }
    @Override
    public void setMakeOrder() {
    if (!this.isMakeOrder) super.isMakeOrder = true;
    }

    @Override
    public void setTakeOrder() {
    if (!this.isTakeOrder) super.isTakeOrder = true;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }



}
