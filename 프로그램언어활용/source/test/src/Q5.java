import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) {
        int [] nums = {21,22,30,11,99,31};
        int [] reverse = new int[nums.length];

        for(int i=nums.length-1,j=0; i>0; i--){
            reverse[j] = nums[i];
            j++;
        }
        System.out.println(Arrays.toString(reverse));

    }
}
