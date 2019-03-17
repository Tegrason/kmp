import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String str1 = "ABABABCBABABABAB";
        String str2 = "AB";
        System.out.println( Compare(Next(str2),str1,str2));
    }
    public static int Compare(int[] next, String str1, String str2){
        for(int i=0,j= 0; i < str1.length(); i++){
            while ( j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j];
            }
            if(j == str2.length() -1 ){
                return i - j;
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j ++;
            }
        }
        return 0;
    }
    public static int[] Next(String str){
        int k = -1;
        int[] next = new int[str.length()];
        next[0] = -1;
        int j = 0;
        while (j < str.length() - 1){
            if(k == -1 || str.charAt(k) == str.charAt(j)){
                ++j;
                ++k;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}
