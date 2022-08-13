import java.util.Scanner;

public class Store extends NormalLocation{

    Scanner input =new Scanner(System.in);
    public Store(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the store !");
        System.out.println("----------------------");
        System.out.println("1-Weapons\n2-Armors\n3-Exit");
        System.out.print("Your choice : ");
        int select =input.nextInt();
        while(select<1 || select>3){
            System.out.print("Select between 1-3 : ");
            select =input.nextInt();
        }
        System.out.println("");
        switch (select){
            case 1:
                printWeapons();
                buyWeapon();
                break;
            case 2:
                printArmors();
                buyArmor();
                break;
            case 3:
                System.out.println("You left the store !");
                break;
            default:
                break;
        }
        return super.onLocation();
    }

    public void printWeapons(){
        System.out.println("----------------Weapons----------------");
        for(Weapon w:Weapon.weapons()){
            System.out.println(w.getId()+"-Name : "+w.getName()+"\tDamage : "+w.getDamage()+"\tPrice : "+w.getPrice());
        }
        System.out.println("0-Exit");
    }
    public void buyWeapon(){
        System.out.print("Select Weapon : ");
        int selectWeapon =input.nextInt();
        while(selectWeapon<0 || selectWeapon>Weapon.weapons().length){
            System.out.print("Select between 0-3 : ");
            selectWeapon =input.nextInt();
        }
        if(selectWeapon!=0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getCost()) {
                    System.out.println("You don't have enough money !");
                } else {
                    System.out.println("You bought a " + selectedWeapon.getName() + " !");
                    int balance = this.getPlayer().getCost() - selectedWeapon.getPrice();
                    this.getPlayer().setCost(balance);
                    System.out.println("Your remaining money : " + balance);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }
    public void buyArmor(){
        System.out.print("Select Armor : ");
        int selectArmor =input.nextInt();
        while(selectArmor<0 || selectArmor>Armor.armors().length){
            System.out.print("Select between 0-3 : ");
            selectArmor =input.nextInt();
        }
        if(selectArmor!=0) {
            Armor selectedArmor = Armor.getArmorById(selectArmor);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getCost()) {
                    System.out.println("You don't have enough money !");
                } else {
                    System.out.println("You bought a " + selectedArmor.getName() + "!");
                    int balance = this.getPlayer().getCost() - selectedArmor.getPrice();
                    this.getPlayer().setCost(balance);
                    System.out.println("Your remaining money : " + balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new armor : " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }

    public void printArmors(){
        System.out.println("----------------Armors----------------");
        for(Armor a:Armor.armors()){
            System.out.println(a.getId()+"-Name : "+a.getName()+"\tBlock : "+a.getBlock()+"\tPrice : "+a.getPrice());
        }
        System.out.println("0-Exit");
    }

}
