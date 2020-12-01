
public class JpnSakeManager extends SakeManager{
    int num;

    public JpnSakeManager(int num){
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
