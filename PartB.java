import java.util.*;

public class partB {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,4};
        int[] num2 = {1, 2, 3, 4, 5, 6, 7, 8};
        int sides = 6;
        List<Integer> diceA = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> diceB = List.of(1, 2, 3, 4, 5, 6);
        List<List<Integer>> possiblesA = new ArrayList<>();
        List<List<Integer>> possiblesB = new ArrayList<>();
        
        Map<Integer, Integer> mapProbabilities = findProbabilities(diceA, diceB);
        possiblesA = combinatinosA(num1,sides);
        possiblesB = combinatinosB(num2,sides);

        int flag = 0;
        for(List<Integer> p1 : possiblesA)
        {
            for(List<Integer> p2 : possiblesB)
            {
                if(checkMaps(p1,p2,mapProbabilities))
                {
                    System.out.println("Transformed Dice A: " + p1);
                    System.out.println("Transformed Dice B: " + p2);
                    flag = 1;
                    break;
                }
                if(flag==1)
                break;
            }
        }
        
    }
    public static List<List<Integer>> combinatinosB(int[] arr, int sides) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(arr[j]);
                }
            }
            if (temp.size() == sides) {
                result.add(temp);
            }
        }
        return result;
    }
    
    public static List<List<Integer>> combinatinosA(int[] arr, int sides) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < Math.pow(n, sides); i++) {
            List<Integer> temp = new ArrayList<>();

            int t = i;
            for (int j = 0; j < sides; j++) {
                int index = t % n;
                temp.add(arr[index]);
                t /= n;
            }

            result.add(temp);
        }

        return result;
    }
    
    public static boolean checkMaps(List<Integer> possiblesA, List<Integer> possiblesB, Map<Integer, Integer> mapProbabilities) {
        Map<Integer, Integer> generatedProbability = findProbabilities(possiblesA, possiblesB);
        return mapProbabilities.equals(generatedProbability);
    }

    public static Map<Integer, Integer> findProbabilities(List<Integer> diceA, List<Integer> diceB) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Integer num1 : diceA) {
            for (Integer num2 : diceB) {
                int sum = num1 + num2;
                result.put(sum, result.getOrDefault(sum, 0) + 1);
            }
        }
        return result;
    }
}