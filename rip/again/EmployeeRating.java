package rip.again;


import java.util.*;

public class EmployeeRating {

    public static void main(String[] args) {
        EmployeeRating employeeRating = new EmployeeRating();
        List<Employee> employees = new ArrayList<>();
        Employee A = new Employee("A", 5, new ArrayList<>(Arrays.asList(new String[]{"B", "C"})));
        Employee B = new Employee("B", 3, new ArrayList<>());
        Employee C = new Employee("C", 2, new ArrayList<>(Arrays.asList(new String[]{"D", "E"})));
        Employee D = new Employee("D", 4, new ArrayList<>());
        Employee E = new Employee("E", 10, new ArrayList<>());
        employees.add(A);
        employees.add(B);
        employees.add(C);
        employees.add(D);
        employees.add(E);
        System.out.println(employeeRating.getEmployeeWithHighestRatingAverage(employees));
    }

    private static class Employee {
        public String id;
        public int rating;
        public List<String> subordinates;

        public Employee(String id, int rating, List<String> subordinates) {
            this.id = id;
            this.rating = rating;
            this.subordinates = subordinates;
        }

        @Override
        public String toString() {
            return "Employee: {" + id + ", " + rating + ", " + subordinates + '}';
        }
    }

    private Map<String, Employee> employeeMap;

    public String getEmployeeWithHighestRatingAverage(List<Employee> employees) {
        employeeMap = new HashMap<>();
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }
        //System.out.println(employeeMap);
        maxAverage(employees.get(0));
        return maxId;
    }

    private static double ans = 0.0;
    private static String maxId = null;

    private int[] maxAverage(Employee root) {
        //System.out.println(root);
        if (root.subordinates != null && root.subordinates.size() == 0) {
            //System.out.println("Leaf Node");
            if (root.rating > ans) {
                ans = root.rating;
                maxId = root.id;
            }
            //System.out.println("leaf ans:" + ans);
            return new int[]{root.rating, 1};
        }

        int[] childResult = new int[2];
        for (String id : employeeMap.get(root.id).subordinates) {
            int[] childTotal = maxAverage(employeeMap.get(id));
            childResult[0] += childTotal[0];
            childResult[1] += childTotal[1];
        }
        int sum = childResult[0] + root.rating;
        int count = childResult[1] + 1;

        if (sum * 1.0 / count > ans) {
            maxId = root.id;
            ans = sum * 1.0 / count;
            //System.out.println("non leaf ans:" + ans);
        }

        return new int[]{sum, count};
    }

}