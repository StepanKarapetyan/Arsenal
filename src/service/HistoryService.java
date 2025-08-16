package service;

public class HistoryService {
    private final String[] HISTORY = new String[1000];
    private int historyCount = 0;

    public void addToHistory(String weaponName, int quantity) {
        if (historyCount < HISTORY.length) {
            HISTORY[historyCount++] = "Weapon: " + weaponName + " Quantity: " + quantity;
        } else {
            System.out.println("You have reached the maximum amount of weapons.");
        }
    }

    public void printHistory() {
        for (int i = 0; i < historyCount; i++) {
            System.out.println("Contract " + (i + 1) + ". " + HISTORY[i]);
        }
    }
}
