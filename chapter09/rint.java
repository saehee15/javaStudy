public class rint {
    public static void main(String[] args){
        double sum = 0;
        double sum1 = 0;
        double sum2 = 0;

        for(double d = 1.5; d<=10.5; d++){
            double d1 = Math.round(d);
            double d2 = Math.rint(d);

            System.out.printf("%4.1f %4.1f %4.1f%n", d, d1, d2);

            sum += d;
            sum1 += d1;
            sum2 += d2;
        }

        System.out.println("-------------");
        System.out.printf("%4.1f %4.1f %4.1f%n", sum, sum1, sum2);
    }
}


// 결과값

//  1.5  2.0  2.0
//  2.5  3.0  2.0
//  3.5  4.0  4.0
//  4.5  5.0  4.0
//  5.5  6.0  6.0
//  6.5  7.0  6.0
//  7.5  8.0  8.0
//  8.5  9.0  8.0
//  9.5 10.0 10.0
// 10.5 11.0 10.0
// --------------
// 60.0 65.0 60.0
//     round  rint