
public class WineManager extends SakeManager{
    int num;

    public WineManager(int num){
    	this.num = num;
    }

    public int getCount(){
        return num;
    }
    public void order(int num){
        this.num -= num;
    }
    public void addStock(int num){
        this.num += num;
    }
}
