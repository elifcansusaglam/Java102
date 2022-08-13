import java.util.Random;
import java.util.Scanner;

public class BattleLocation extends Location{
    Scanner input=new Scanner(System.in);
    private Monster monster;
    private int maxMonster;
    private boolean water,food,firewood;
    public BattleLocation(Player player, String locationName,Monster monster,int maxMonster) {
        super(player, locationName);
        this.monster=monster;
        this.maxMonster=maxMonster;
    }

    public int generateRandomMonsterNumber(){
        Random r=new Random();
        return r.nextInt(getMaxMonster())+1;
    }
    @Override
    public boolean onLocation() {


        int randomMonsterNumber = generateRandomMonsterNumber();
        System.out.println("Be careful! You are in "+this.getLocationName()+"!");
        System.out.println(randomMonsterNumber+" "+this.monster.getName()+"s are living hear! Fight or flight!");
        System.out.println("\nTo Fight : 1\tTo Flight : 2");
        System.out.print("Your choice : ");
        int selected =input.nextInt();
        if(selected==1 && war(randomMonsterNumber)){

            System.out.println("You killed all monsters in "+ this.getLocationName()+"!" );
            if(getLocationName().equals("Cave")){
                Award award=Award.getAwardById(1);
                System.out.println("You earn : "+award.getName());
                this.getPlayer().getInventory().getAward().setName(award.getName());
                this.setFood(true);
            } else if(getLocationName().equals("Forest")){
                Award award=Award.getAwardById(2);
                System.out.println("You earn : "+award.getName());
                this.getPlayer().getInventory().getAward().setName(award.getName());
                setFirewood(true);

            } else if(getLocationName().equals("River")){
                Award award=Award.getAwardById(3);
                System.out.println("You earn : "+award.getName());
                this.getPlayer().getInventory().getAward().setName(award.getName());
            }if(food && water && firewood){
                System.out.println("Congratulations you got all the rewards !");
                System.out.println("YOU WON THE GAME!");
            }
            return true;
        }
        if(this.getPlayer().getHealth()<=0) {
            return false;
        }
        return true;
    }
    public boolean war(int maxMonster){
        for (int i=1;i<=maxMonster;i++){
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            playerStats();
            monsterStats(i);
            while(this.getPlayer().getHealth()>0 && this.getMonster().getHealth()>0){
                System.out.println("\nTo Hit : 1\tTo Run : 2");
                System.out.print("Your choice : ");
                int selected =input.nextInt();
                System.out.println("");
                if(selected==1){
                    System.out.print("You hit monster!");
                    this.getMonster().setHealth(this.getMonster().getHealth()-this.getPlayer().getDamage());
                    afterHit();
                    if(this.getMonster().getHealth()>0){
                        System.out.print("Monster hit you !");
                        int monsterDamage=this.getMonster().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if(monsterDamage<0){
                            monsterDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterDamage);
                        afterHit();
                    }
                    else{
                        System.out.println("You killed the "+i+". monster !");
                    }
                }
                if(selected==2){
                    this.getPlayer().selectLocation();
                }
            }
        }
        if(this.getMonster().getHealth()<this.getPlayer().getHealth()){
            System.out.println("You killed all monsters and you earned "+this.getMonster().getReward()+" money!");
            this.getPlayer().setCost(this.getPlayer().getCost()+this.getMonster().getReward());
            System.out.println("Your money : "+this.getPlayer().getCost());
        }else{
            return false;
        }
        return true;
    }
    public void playerStats(){
        System.out.println("\n---------------------------Player  Stats---------------------------------------------------------");
        System.out.println("Name : "+this.getPlayer().getName() + "\t\tHealth : "+this.getPlayer().getHealth()+
                "\t\tDamage : "+this.getPlayer().getTotalDamage()+
                "\t\tMoney : "+this.getPlayer().getCost()+
                "\t\tWeapon : "+this.getPlayer().getInventory().getWeapon().getName()+
                "\t\tArmor : "+this.getPlayer().getInventory().getArmor().getName()+
                "\t\tBlock : "+this.getPlayer().getInventory().getArmor().getBlock()+
                "\t\tReward: "+this.getPlayer().getTotalAwards()+"\n");
    }
    public void monsterStats(int i){

        System.out.println("\n------------------------------Monster Stats---------------------");
        System.out.println(i+".Name: "+this.getMonster().getName()+
                "\t\tHealth : "+this.getMonster().getHealth()+
                "\t\tDamage : "+this.getMonster().getDamage()+
                "\t\t Reward : "+this.getMonster().getReward()+"\n");

    }
    public void afterHit(){

        System.out.println("\nYour health : " + this.getPlayer().getHealth() );
        System.out.println("Monster's health : " + this.getMonster().getHealth());
        System.out.println();
    }

    public Monster getMonster() {
        return monster;
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean getFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }


}
