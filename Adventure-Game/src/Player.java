import java.util.Scanner;
public class Player {
    private int id;
    private int damage;
    private int cost;
    private int health;
    private String name;
    private String characterName;
    private int defaultHealth;
    private Inventory inventory;
    private boolean control;
    private Award award;
    private String awards;
    private Scanner input =new Scanner(System.in);

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }
    public void selectCharacter() {
        Characters[] characterList = {new Samurai(), new Archer(), new Knight()};

        for (Characters c : characterList) {
            System.out.println(c.getId() + ". Character : " +
                    "\t\tName : " + c.getName() +
                    "\t\tDamage : " + c.getDamage() +
                    "\t\tHealth : " + c.getHealth() +
                    "\t\tMoney : " + c.getCost()
            );
        }
        System.out.println("----------------------------------------------------------------------------------");
        boolean isTrue=true;
        while (isTrue) {
            System.out.print("Select a character between 1-3 : ");
            int selectedCharacter = input.nextInt();
            System.out.println();
            switch (selectedCharacter) {
                case 1:
                    initPlayer(new Samurai());
                    isTrue=false;
                    break;
                case 2:
                    initPlayer(new Archer());
                    isTrue=false;
                    break;
                case 3:
                    initPlayer(new Knight());
                    isTrue=false;
                    break;
                default:
                    continue;
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Your Character is : " + this.getCharacterName());
        }
    }
    public void initPlayer(Characters characters){
        this.setId(characters.getId());
        this.setCharacterName(characters.getName());
        this.setDamage(characters.getDamage());
        this.setHealth(characters.getHealth());
        this.setDefaultHealth(characters.getHealth());
        this.setCost(characters.getCost());
        this.setAwards(characters.getAwards());
    }
    public void printInfo(){

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Your Weapon : " + this.getInventory().getWeapon().getName()+
                "\t\tYour armor : "+this.getInventory().getArmor().getName()+
                "\t\tBlock: "+this.getInventory().getArmor().getBlock()+
                "\t\tDamage : " + this.getTotalDamage() +
                "\t\tHealth : " + this.getHealth() +
                "\t\tMoney : " + this.getCost()+
                "\t\tRewards: "+this.getTotalAwards());
    }

    public void selectLocation(){
        boolean isTrue=true;
        while(isTrue) {
            printInfo();
            Location location = null;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("1.Location Safe House : There is no enemy in hear !\n" +
                    "2.Location Store  : You can get weapons and armors in hear !\n"+
                    "3.Location Cave   : Be careful you can see zombies but you can get food !\n"+
                    "4.Location Forest : Be careful you can see vampires but you can get firewood !\n"+
                    "5.Location River  : Be careful you can see bears but you can get water !\n"+
                    "0.Exit : You can left the game ! ");
            System.out.println("");
            System.out.print("Select a location : ");
            int selectLocation = input.nextInt();
            System.out.println("");

            switch (selectLocation) {
                case 0:
                        location=null;
                    break;
                case 1:
                        location = new SafeHouse(this);
                    break;
                case 2:
                        location = new Store(this);
                    break;
                case 3:
                    if(this.getInventory().getAward().getName()=="Food"){
                        System.out.println("You have already got all rewards!");
                        System.out.println("You cannot enter the cave again!\n");
                        continue;
                    }else{
                        location=new Cave(this);
                    }
                    break;
                case 4:
                    if(this.getInventory().getAward().getName()=="Firewood"){
                        System.out.println("You have already got all rewards!");
                        System.out.println("You cannot enter the forest again!\n");
                        continue;
                    }else{
                        location=new Forest(this);
                    }
                    break;
                case 5:
                    if(this.getInventory().getAward().getName()=="Water"){
                        System.out.println("You have already got all rewards!");
                        System.out.println("You cannot enter the river again!\n");
                        continue;
                    }else{
                        location=new River(this);
                    }
                    break;
                    default:
                        location = new SafeHouse(this);
                    break;
            }
            if(location==null){
                System.out.println("You left the game !");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("---------------------");
                System.out.println("YOU DEAD! GAME OVER! ");
                System.out.println("---------------------");
                isTrue=false;
            }
        }
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getTotalDamage() {

        return damage+this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {

        return damage;
    }
    public void setDamage(int damage){
        this.damage= damage;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health){
        if(health<0){
            health=0;
        }
        this.health= health;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName){
        this.characterName=characterName;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getTotalAwards() {

        return awards+this.getInventory().getAward().getName();
    }



}
