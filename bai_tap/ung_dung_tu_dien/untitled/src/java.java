public class java {
   static int solution(int[] q, int e) {
        int r = 0;
        boolean f = false;
        for (int t : q) {
            if (t == 0) {
                return 0;
            }
            if (e % t == 0) {
                f = true;
            }
            r += t;
        }

        if (f) {
            return r + e;
        }
        return 0;
    }

    public static void main(String[] args) {
       int [] k = {5,5,2};
        System.out.println(  solution (k, 4 ) );

    }
}
