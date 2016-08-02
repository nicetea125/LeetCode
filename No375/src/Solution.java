import java.util.*;


public class Solution {

    private static Map<String,Integer> map = new HashMap<String,Integer>();

    public static void main(String[] args)  {
        System.out.print( getMoneyAmount(200) );
    }

    public static int getMoneyAmount(int n) {
        return getCost(1,n);
    }

    public static int getCost(int s,int e){
        if(map.get(s+"_"+e) != null) return map.get(s+"_"+e);

        int n = e - s + 1;
        int cost = 0;
        if(n==3){
            cost = s+1;
        }else if(n==2){
            cost = s;
        }else if(n<2){
            cost = 0;
        }else if(n>3){
            int minC = 2147483647;
            for(int d=s+1;d<e;d++){
                /*
                int fCost = getCost(s,d-1);
                int sCost = getCost(d+1,e);
                int _cost = (fCost > sCost) ? fCost : sCost;
                _cost += d;
                minC = (minC > _cost) ? _cost : minC;
                */
                minC = Math.min(minC, d + Math.max(getCost(s,d-1),getCost(d+1,e)) );
            }
            cost = minC;
        }

        map.put(s+"_"+e , cost);
        return map.get(s+"_"+e);
    }
}