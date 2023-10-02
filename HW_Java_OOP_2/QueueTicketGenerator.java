import java.util.Random;

public class QueueTicketGenerator {
    private static int letterIndex = 0;
    private static int number = 1;

    public static String generateTicket() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String result = "";
        final int bound = 99;
        if (letterIndex == letters.length()){
            letterIndex = 0;
            number = 1;
        }
        if (number > bound) {
            letterIndex++;
            number = 0;
        } else if (number < 10){
            result = result + letters.charAt(letterIndex) + "0" + number;
            number++;
        } else {
            result = result + letters.charAt(letterIndex) + number;
            number++;
        }

        return result;
    }
}
