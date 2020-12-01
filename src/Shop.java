import java.util.*;

public class Shop {
	final int INSTOCK_WINE = 50;
	final int INSTOCK_JPNSAKE = 60;
	int STOCK[] = {INSTOCK_WINE, INSTOCK_JPNSAKE};
	ArrayList<SakeManager> al = new ArrayList<SakeManager>();
	Reservation r = new Reservation();

	public int[] getCount(){
		int[] cnt = new int[2];
		for (int i=0; i<al.size(); i++){
            cnt[i] = al.get(i).getCount();
		}
		return cnt;
	}

	public void order(int n[]){//n[]は入力
		int flag = 0;
		for (int i=0; i<al.size(); i++){
			if(al.get(i).getCount() < n[i]) flag = 1;
		}
		if(flag == 0){//在庫の方が多いとき
			for (int i=0; i<al.size(); i++){
				al.get(i).order(n[i]);
			}
			System.out.println("出荷されました");
			System.out.println(al.get(0).getCount());
			System.out.println(al.get(1).getCount());

		}else if(flag == 1){//在庫の方が少ないとき、予約に回る
			r.addReserve(n);
			System.out.println("予約に回りました。予約番号：");
		}
	}

	public void addStock(int instock[]){
		for (int i=0; i<al.size(); i++){
            al.get(i).addStock(instock[i]);
		}
		int stock[] = getCount();
		while(r.peekReserve(stock)){
			int res[] = r.popReserve();
			order(res);
		}
	}

	public void judge(int n[]){
		int l = n.length;
		if(l == (al.size()+1)){
			if(n[l-1] == 0){
				order(n);
			}else if(n[l-1] == -1){
				addStock(STOCK);
			}
		}else{
			System.err.println("不正な入力です");
		}
	}

	public static void main(String[] args) {

		int[] currentStocks = {20, 30};
		int[] inputs = new int[3];
		Shop s = new Shop();
		s.al.add(new WineManager(currentStocks[0]));
		s.al.add(new JpnSakeManager(currentStocks[1]));
		Scanner sc = new Scanner(System.in);
		while(true){
			for(int i = 0; i < inputs.length; i++) {
				inputs[i] = sc.nextInt();
			}
			s.judge(inputs);
			if(inputs[0] == -1){
				break;
			}
		}
		sc.close();
	}



}
