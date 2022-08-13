public class Monster {
    private String Name;
    private int id;
    private int damage;
    private int health;
    private int defaultHealth;
    private int reward;

    public Monster(String name, int id, int damage, int health,int reward) {
        Name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.defaultHealth= health;
        this.reward = reward;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }
    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

}
