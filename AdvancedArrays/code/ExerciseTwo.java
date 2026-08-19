import java.util.LinkedList;
import java.util.Queue;

class Ticket{
    int id;
    String issueDescription;

    public Ticket(int id, String issueDescription){
        this.id = id;
        this.issueDescription = issueDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }
}

public class AdvancedArrays {
    public static void main(String[] args) {
        Queue<Ticket> queue = new LinkedList<>();
        Ticket one = new Ticket(1, "Fix bug for FR-1");
        Ticket two = new Ticket(2, "Fix bug for FR-2");
        queue.offer(one);
        queue.offer(two);

        while (!queue.isEmpty()) {
            Ticket element = queue.poll();
            System.out.println("Ticket id: " + element.getId() + " description: " + element.getIssueDescription());
        }
    }
}
