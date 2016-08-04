import java.util.*;


public class No312 {

    private static Map<ArrayList<Integer>,Integer> map = new HashMap<ArrayList<Integer>,Integer>();

    public static void main(String[] args)  {
        int[] nums = {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2};
        System.out.print( maxCoins(nums) );
    }

    public static int maxCoins(int[] nums) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int s : nums) { numList.add(s);}
        return getMaxCoin(numList);
    }

    public static int getMaxCoin(ArrayList<Integer> numList){
        if(map.get(numList) != null) return map.get(numList);

        int size = numList.size();
        int coins = 0;
        if(size == 1){
            coins = numList.get(0);
        }else{
            int maxC = 0;
            for(int i=0;i<size;i++){
                int _coin = getBurstCoin(numList, i, size);
                ArrayList<Integer> _nlCopy = (ArrayList) numList.clone();
                _nlCopy.remove(i);
                maxC = Math.max( maxC, _coin + getMaxCoin(_nlCopy) );
            }
            coins = maxC;
        }

        map.put(numList , coins);
        return coins;
    }

    public static int getBurstCoin(ArrayList<Integer> numList, int i, int size){
        int left  = (i==0) ? 1 : numList.get(i-1);
        int right = (i==size-1) ? 1 : numList.get(i+1);
        return left * numList.get(i) * right;
    }
}