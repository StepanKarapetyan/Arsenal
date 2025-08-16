package weapon;

public interface WeaponProducer {
    boolean canProduce(String weaponName);
    void produce(String weaponName, int quantity, WeaponStorage storage);
}
