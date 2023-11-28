package rip.ultimate;

import java.util.*;

//https://leetcode.com/discuss/interview-question/1650545/Rippling-or-SE-or-DSAlgo-Round-orHighest-performing-rating-employee-team

class EmployeeReview {
    String id;
    int rating;
    List<String> subordinates;

    public EmployeeReview(String id, int rating, List<String> subordinates) {
        this.id = id;
        this.rating = rating;
        this.subordinates = subordinates;
    }

    public static double bestTeam(List<EmployeeReview> empHead) {
        Map<String, List<String>> empAdj = new HashMap<>();
        Map<String, Integer> empRating = new HashMap<>();

        for (EmployeeReview emp : empHead) {
            empAdj.put(emp.id, emp.subordinates);
            empRating.put(emp.id, emp.rating);
        }

        double maxAvg = 0;

        for (String emp : empAdj.keySet()) {
            double[] result = getTeamRatingSize(emp, empAdj, empRating);
            double rating = result[0];
            double size = result[1];
            maxAvg = Math.max(rating / size, maxAvg);
        }

        return maxAvg;
    }

    private static double[] getTeamRatingSize(String emp, Map<String, List<String>> empAdj, Map<String, Integer> empRating) {
        if (empAdj.get(emp).isEmpty()) {
            return new double[]{empRating.get(emp), 1};
        }

        double totalRating = empRating.get(emp);
        double totalTeam = 1;
        List<String> subs = empAdj.get(emp);

        for (String sub : subs) {
            double[] result = getTeamRatingSize(sub, empAdj, empRating);
            double subRating = result[0];
            double subSize = result[1];
            totalRating += subRating;
            totalTeam += subSize;
        }

        return new double[]{totalRating, totalTeam};
    }

    public static void main(String[] args) {
        List<EmployeeReview> employees = new ArrayList<>();

        EmployeeReview a = new EmployeeReview("A", 5, Arrays.asList("B", "C"));
        EmployeeReview b = new EmployeeReview("B", 3, Arrays.asList());
        EmployeeReview c = new EmployeeReview("C", 24, Arrays.asList("D", "E"));
        EmployeeReview d = new EmployeeReview("D", 47, Arrays.asList());
        EmployeeReview e = new EmployeeReview("E", 16, Arrays.asList());


        employees.add(a);
        employees.add(b);
        employees.add(c);
        employees.add(d);
        employees.add(e);

        System.out.println(bestTeam(employees));
    }

}
