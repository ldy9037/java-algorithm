package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q11 {
    public static void main(String[] args){
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        SolutionQ11 solution = new SolutionQ11();
        consoleOut(solution.solution(tickets));
    }

    private static void consoleOut(String[] result) {
        System.out.println(Arrays.toString(result)); // ["ICN", "JFK", "HND", "IAD"]
    }
}

class SolutionQ11 {
    public String[] solution(String[][] tickets) {
        List<Plan> answer = new ArrayList<>();

        List<String> location = new ArrayList<>();
        location.add("ICN");

        Queue<Plan> queue = new LinkedList<>();
        queue.add(new Plan(location, Arrays.asList(tickets)));

        while (!queue.isEmpty()) {
            Plan plan = queue.poll();
            
            if (plan.getLocation().size() == tickets.length + 1) {
                answer.add(plan);
                continue;
            }

            queue.addAll(plan.nextPlans());
        }

        Collections.sort(answer, new Comparator<Plan>() {
            @Override
            public int compare(Plan o1, Plan o2) {
                return String.join("", o1.getLocation())
                        .compareTo(String.join("", o2.getLocation()));
            }
        });

        return answer.get(0)
                .getLocation()
                .toArray(new String[tickets.length + 1]);
    }
}

class Plan {
    private List<String> location;
    private List<String[]> tickets;

    Plan (List<String> location, List<String[]> tickets) {
        this.location = location;
        this.tickets = tickets;
    }

    public List<String> getLocation() {
        return location;
    }

    public List<Plan> nextPlans() {
        List<Plan> result = new ArrayList<>();
        
        for (String[] ticket : tickets) {
            if (ticket[0].equals(location.get(location.size() - 1))) {
                List<String> nextLocation = new ArrayList<>(location);
                Collections.copy(nextLocation, location);
                
                nextLocation.add(ticket[1]);

                List<String[]> nextTickets = new LinkedList<>(tickets);
                Collections.copy(nextTickets, tickets);
                nextTickets.remove(ticket);

                result.add(new Plan(nextLocation, nextTickets));
            }
        }

        return result;
    }
}