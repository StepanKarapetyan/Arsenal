package weapon;

public class WeaponStorage {

    private String[] weapons = new String[1000];
    private int weaponsCount = 0;

    private static final String[] INITIAL_WEAPONS = {
            "AK-47 - Assault Rifle",
            "AK-114 - Assault Rifle",
            "AK-115 - Assault Rifle",
            "AWP - Sniper Rifle",
            "Glock-18 - Pistol",
            "F-1 - Grenade",
            "T-34 - Tank",
            "MIG-27 - Destroyer",
            "Knife - Cold weapon",
            "SU-17 - Destroyer"
    };

    private static final int[] INITIAL_QUANTITY = {
            20,
            12,
            8,
            25,
            65,
            40,
            50,
            27,
            450,
            0
    };

    public WeaponStorage() {
        for (int i = 0; i < INITIAL_WEAPONS.length; i++) {
            String weapon = INITIAL_WEAPONS[i];
            int quantity = INITIAL_QUANTITY[i];
            for (int j = 0; j < quantity; j++) {
                addWeapon(weapon + " (preloaded) ");
            }
        }
    }

    public void addWeapon(String weapon) {
        if (weaponsCount < weapons.length) {
            weapons[weaponsCount++] = weapon;
        }
    }

    public int countWeapons(String weaponName) {
        int count = 0;
        for (int i = 0; i < weaponsCount; i++) {
            if (weapons[i] != null && weapons[i].startsWith(weaponName)) {
                count++;
            }
        }
        return count;
    }

    public void removeWeapon(String name, int quantity) {
        for (int i = 0; i < weaponsCount; i++) {
            if (weapons[i] != null && weapons[i].startsWith(name)) {
                weapons[i] = null;
            }
        }

        String[] temp = new String[1000];
        int tempCount = 0;
        for (int i = 0; i < weaponsCount; i++) {
            if (weapons[i] != null) {
                temp[tempCount++] = weapons[i];
            }
        }
        weapons = temp;
        weaponsCount = tempCount;
    }

    public void prtintStock() {
        System.out.println("Current stock:");

        String[] uniqueWeapons = new String[weaponsCount];
        int[] counts = new int[weaponsCount];
        int uniqueCount = 0;
        for (int i = 0; i < weaponsCount; i++) {
            if (weapons[i] == null) continue;

            String weaponName = weapons[i];
            int index = -1;
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueWeapons[j].equals(weaponName)) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                uniqueWeapons[uniqueCount] = weaponName;
                counts[uniqueCount] = 1;
                uniqueCount++;
            } else {
                counts[index]++;
            }
        }
        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(" - " + uniqueWeapons[i] + " " + counts[i] + "x");
        }
    }


}
