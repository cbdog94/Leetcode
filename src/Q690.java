import java.util.*;

public class Q690 {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int importance = 0;
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            importance += e.importance;
            for (int eid : e.subordinates) {
                queue.offer(map.get(eid));
            }
        }
        return importance;
    }

    public int getImportance(List<Employee> employees, Map<Integer, Employee> map, int id) {
        int importance = 0;
        Employee e = map.get(id);
        importance += e.importance;
        for (int eid : e.subordinates) {
            importance += getImportance(employees, eid);
        }
        return importance;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

}
