package rip.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Employee {
    String id;

    int importance;

    List<String> sub;

    Employee(String id, int importance, List<String> sub) {
        this.id = id;
        this.importance = importance;
        this.sub = sub;
    }

    public static double highestPerformingTeam(List<Employee> eList) {

        HashMap<String, List<String>> managerMap = new HashMap<>();

        HashMap<String, Integer> ratingMap = new HashMap<>();


        for (Employee e : eList) {
            managerMap.put(e.id, e.sub);
            ratingMap.put(e.id, e.importance);
        }

        double maxAvg = 0;
        String teamName = "";

        for (String e : managerMap.keySet()) {
            double[] tempTeamRating = getMyTeamRating(e, managerMap, ratingMap);

            if (maxAvg < tempTeamRating[0] / tempTeamRating[1]) {
                maxAvg = tempTeamRating[0] / tempTeamRating[1];
                teamName = e;
            }
        }

        System.out.println(teamName);

        return maxAvg;
    }

    private static double[] getMyTeamRating(String m, HashMap<String, List<String>> managerMap, HashMap<String, Integer> ratingMap) {

        if (managerMap.get(m).isEmpty()) {
            return new double[]{ratingMap.get(m), 1};
        }

        double myTeamRating = ratingMap.get(m);
        double mySize = 1;

        for (String e : managerMap.get(m)) {

            double[] teamRating = getMyTeamRating(e, managerMap, ratingMap);

            myTeamRating += teamRating[0];
            mySize += teamRating[1];
        }

        return new double[]{myTeamRating, mySize};

    }

    public static void main(String[] args) {

//        Sample input/output:
//        Input format: [employee name, rating, List]
//        data = [["A", 5, ["B", "C"]], ["B", 3, []], ["C", 2, ["D", "E"]], ["D", 4, []], ["E", 10, []]

        Employee A = new Employee("A", 5, new ArrayList<>(Arrays.asList(new String[]{"B", "C"})));

        Employee B = new Employee("B", 3, new ArrayList<>(Arrays.asList()));

        Employee C = new Employee("C", 24, new ArrayList<>(Arrays.asList("D", "E")));

        Employee D = new Employee("D", 40, new ArrayList<>(Arrays.asList()));

        Employee E = new Employee("E", 16, new ArrayList<>(Arrays.asList()));

        System.out.println(highestPerformingTeam(new ArrayList<>(Arrays.asList(A, B, C, D, E))));

    }


}
