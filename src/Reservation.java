import java.util.*;

public class Reservation {
    Deque<int[]> que = new ArrayDeque<>();
    int id = 1;//予約番号

    public void addReserve(int n[]){
        int l = n.length;
        n[l-1] = id;
        que.add(n);
        id++;
    }

    public boolean peekReserve(int stock[]){
        if(que.size() == 0){
            return false;
        }

        int m[] = que.peek();

        int flag = 0;
        for(int i=0; i<stock.length; i++){
            if(m[i] > stock[i]) flag = 1;//在庫が足りないとき
        }
        if(flag == 0){
            return true;
        }else{
            return false;
        }
    }

    public int[] popReserve(){
        return que.pop();
    }
}
