public class Award {
    private String name;
    private int id;

    private boolean control;
    public Award(String name, int id,boolean control) {
        this.name = name;
        this.id = id;
        this.control=control;
    }
    public static Award[] awards(){
        Award[] awardList=new Award[3];
        awardList[0]=new Award("Food",1,false);
        awardList[1]=new Award("Firewood",2,false);
        awardList[2]=new Award("Water",3,false);

        return awardList;
    }
    public static Award getAwardById(int id){
        for(Award a: Award.awards()){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isControl() {
        return control;
    }
    public void setControl(boolean control) {
        this.control = control;
    }
}
