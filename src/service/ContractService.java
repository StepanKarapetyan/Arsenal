package service;

import weapon.WeaponFactory;
import weapon.WeaponProducer;
import weapon.WeaponStorage;
import model.Contract;

public class ContractService extends WeaponFactory {
    private WeaponStorage storage;
    private WeaponProducer producer;

    public ContractService(WeaponStorage storage, WeaponProducer producer) {
        this.storage = storage;
        this.producer = producer;
    }

    public void processContract(Contract contract) {
        String weaponName = contract.getWeaponName().trim();
        int quantity = contract.getQuantity();

        if (!canProduce(weaponName)) {
            contract.setStatus(contract.isFulfilled(), "Our factory does not produce \" " + weaponName + " \" weapon");
            System.out.println(contract.getStatusMessage());
            System.out.println();
            return;
        }

        int available = storage.countWeapons(weaponName);
        if (available >= quantity) {
            storage.removeWeapon(weaponName, quantity);
            contract.setStatus(contract.isFulfilled(), "The contract is fulfilled. Delivered " + quantity + " units from \"" + weaponName + " \"Storehouse.");
        } else {

            int toProduce = quantity - available;
            if (toProduce > 0) {
                storage.removeWeapon(weaponName, quantity);
            }

            producer.produce(weaponName, toProduce, storage);
            storage.removeWeapon(weaponName, toProduce);

            contract.setStatus((contract.isFulfilled()), "The contract is fulfilled. Delivered " + available + " units from storehouse \"" + toProduce + " units produced \"" + weaponName + "\".");
        }
        System.out.println(contract.getStatusMessage());
        System.out.println();
    }
}
