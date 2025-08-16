package weapon;

public class WeaponFactory implements WeaponProducer {

    public static final String[] ALLOWED_WEAPONS = {
            "AK-47", "AK-114", "AK-115", "AWP", "Glock-18", "F-1", "T-34", "MIG-27", "Knife", "SU-17"
    };

    @Override
    public boolean canProduce(String weaponName) {
        for (String allowed : ALLOWED_WEAPONS) {
            if (allowed.equalsIgnoreCase(weaponName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void produce(String weaponName, int quantity, WeaponStorage storage) {
        for (int i = 0; i < quantity; i++) {
            storage.addWeapon(weaponName + "(produced)");
        }
    }
}
