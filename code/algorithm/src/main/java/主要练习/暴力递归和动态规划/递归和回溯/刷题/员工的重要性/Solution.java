package 主要练习.暴力递归和动态规划.递归和回溯.刷题.员工的重要性;

import java.util.*;

public class Solution {
    //id --> 员工在列表中的位置
    HashMap<Integer,Integer> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(int i = 0; i < employees.size(); i++)
            map.put(employees.get(i).id, i);
        return dfs(employees, id);
    }
    public int dfs(List<Employee> employees, int id){
        Employee employee = employees.get(map.get(id));
        int res = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            res += dfs(employees,subordinate);
        }
        return res;
    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}