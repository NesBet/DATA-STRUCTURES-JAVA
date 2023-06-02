import java.util.*;

public class CourseGradebook extends Gradebook {
    // Declare any protected fields here (change placeholder field below)
    protected int field;

    private HashMap<String, HashMap<Integer, Double>> gradebook;

    public CourseGradebook() {
        gradebook = new HashMap<>();
    }

    @Override
    public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
        if (gradebook.containsKey(assignmentName)) {
            return gradebook.get(assignmentName);
        }
        return new HashMap<>();
    }

    @Override
    public double getScore(String assignmentName, Integer studentID) {
        if (gradebook.containsKey(assignmentName)) {
            HashMap<Integer, Double> assignmentScores = gradebook.get(assignmentName);
            if (assignmentScores.containsKey(studentID)) {
                return assignmentScores.get(studentID);
            }
        }
        return Double.NaN;
    }

    @Override
    public ArrayList<String> getSortedAssignmentNames() {
        ArrayList<String> sortedAssignmentNames = new ArrayList<>(gradebook.keySet());
        Collections.sort(sortedAssignmentNames);
        return sortedAssignmentNames;
    }

    @Override
    public ArrayList<Integer> getSortedStudentIDs() {
        HashSet<Integer> studentIDs = new HashSet<>();
        for (HashMap<Integer, Double> assignmentScores : gradebook.values()) {
            studentIDs.addAll(assignmentScores.keySet());
        }
        ArrayList<Integer> sortedStudentIDs = new ArrayList<>(studentIDs);
        Collections.sort(sortedStudentIDs);
        return sortedStudentIDs;
    }

    @Override
    public HashMap<String, Double> getStudentScores(Integer studentID) {
        HashMap<String, Double> studentScores = new HashMap<>();
        for (Map.Entry<String, HashMap<Integer, Double>> entry : gradebook.entrySet()) {
            String assignmentName = entry.getKey();
            HashMap<Integer, Double> assignmentScores = entry.getValue();
            if (assignmentScores.containsKey(studentID)) {
                double score = assignmentScores.get(studentID);
                studentScores.put(assignmentName, score);
            }
        }
        return studentScores;
    }

    @Override
    public void setScore(String assignmentName, Integer studentID, Double score) {
        if (!gradebook.containsKey(assignmentName)) {
            gradebook.put(assignmentName, new HashMap<>());
        }
        HashMap<Integer, Double> assignmentScores = gradebook.get(assignmentName);
        assignmentScores.put(studentID, score);
    }
}
