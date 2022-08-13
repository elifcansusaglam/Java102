public class Inventory {
    private Weapon weapon;
    private Award award;
    private  Armor armor;
    public Inventory(){
        this.weapon=new Weapon("Punch",0,0,0);
        this.armor=new Armor("None",0,0,0);
        this.award=new Award("None",0,false);
    }
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

}
