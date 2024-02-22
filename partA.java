/**
 * partA
 */
public class partA {

    public static void main(String[] args) {

        // 1.1
        System.out.println("Total no of combinations are possible : " + (6*6)+"\n");
        // 1.2
        System.out.println("All the possible combinaitons are ");
        for(int i=1;i<=6;i++){
            for(int j=1;j<=6;j++){
                System.out.printf("(" + i + "," + j+") " );
            }
            System.out.println();
        }
        System.out.println();

        int [] diceA = {1,2,3,4,5,6};
        int [] diceB = {1,2,3,4,5,6};

        int [] sum = new int[13];
        for(int i=0;i<diceA.length;i++){
            for(int j=0;j<diceB.length;j++){
                sum[diceA[i]+diceB[j]]++;
            }
        }

        System.out.println("Sum\tNo_of_times\tProbability");
        for(int i=2;i<sum.length;i++){
            System.out.printf(i + "\t" + sum[i] + "\t\t" + "%.2f\n",(float)sum[i]/36);
        }            


    }
}