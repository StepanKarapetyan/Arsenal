package model;

public class Contract {
    private String weaponName;
    private int quantity;
    private boolean fulfilled;
    private String statusMessage;

    public Contract(String weaponName, int quantity) {
        this.weaponName = weaponName;
        this.quantity = quantity;
        this.fulfilled = false;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatus(boolean fulfilled, String message) {
        if (fulfilled) {
            this.fulfilled = true;
        } else {
            this.fulfilled = false;
        }
        this.statusMessage = message;
    }
}
