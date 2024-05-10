
    public class Node {
        int studentId;
        String additonalInfo;
        Node next;
        Node prev;

        public Node() {
            this.studentId = 0;
            additonalInfo = null;
        }

        public Node(int studentId) {
            this.studentId = studentId;
            next = null;
            prev = null;
        }

        public Node(int studentId, String additonalInfo) {
            this.studentId = studentId;
            this.additonalInfo = additonalInfo;
            next = null;
            prev = null;
        }

        @Override
        public String toString() {
            return "Student Object { " + "studentId=" + studentId + " Student info: " + additonalInfo + " }";
        }

        public long getPrivateStudentId() {
            return studentId;
        }


        public void setStudentId(int value) {
            this.studentId = value;
        }
    }