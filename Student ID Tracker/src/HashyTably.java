import java.util.ArrayList;

public class HashyTably {
    Node[] studentArray;
    int index =0;
    int collision = 0;

    public HashyTably() {
        studentArray = new Node[1000099];
    }

    public int firstHashFunction(int id) {
        if (id > 0) {
            return id % 1000099;
        } else {
            return -1; //**** should handle this case to not throw and error later
        }
    }

    public int secondHashFunction(long id) {
        final int C = 17;
        // Perform a different type of hashing
        int hash = (int) (((id * C) + 1) % 1000099);

        hash = (hash < 0) ? (hash + 1000099) : hash;
        // Ensure that the second hash function never returns 0
        return (hash == 0) ? 1 : hash;
    }

    public int addAll(LinkyListy l) {
        Node temp = l.head;
        while (temp != null) {
            addNode(temp);
            temp = temp.next;
        }
        return collision;
    }

    /**
     * function takes Node then add it to the Hash array this is a belper method for addAll(LinkyListy l)
     */
    public void addNode(Node n) {
        int firstHashOutput = firstHashFunction((int) n.studentId);
        if ((studentArray[firstHashOutput] == null || studentArray[firstHashOutput].studentId <= 0) && n.studentId > 0) {
            studentArray[firstHashOutput] = n;
        } else if (studentArray[firstHashOutput] != null && n.studentId > 0) {
            int secondHashOutput = secondHashFunction(n.studentId);
            while (studentArray[firstHashOutput] != null && studentArray[firstHashOutput].studentId > 0) {
//                System.out.println("hashing again");
                collision++;
                firstHashOutput += secondHashOutput;
                if (firstHashOutput >= 1000099) {
                    firstHashOutput = firstHashOutput - 1000098;
                }
            }
            studentArray[firstHashOutput] = n;
        }
    }


    public void showContent() {
        for (int i = 0; i < 1000099; i++) {
            if (studentArray[i] != null && studentArray[i].studentId > 0) {
                System.out.println("Student at index " + i + " has id = " + studentArray[i].studentId + "-->");
            }
        }
    }

    public int[] keys() {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < studentArray.length; i++) {

            if (this.studentArray[i] != null && this.studentArray[i].studentId > 10000) {
                a.add(this.studentArray[i].studentId);
            }
        }
        return convertArrayListToArray(a);
    }

    public static int[] convertArrayListToArray(ArrayList<Integer> arrayList) {
        // Create a new array of ints
        int[] array = new int[arrayList.size()];

        // Copy elements from ArrayList to the array
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }

        return array;
    }

    public Node goTo(int index) {
        return studentArray[index];
    }

    public Node getNode(int id) {
        int FHF = firstHashFunction(id);
        int SHF = secondHashFunction(id);
        int counter = 0;
        if (studentArray[FHF] == null || studentArray[FHF].studentId < 0) {
            System.out.println("key is not in the set");
            return null;
        } else if (studentArray[FHF].studentId == id) {
            index = FHF;
            return studentArray[FHF];
        } else {
            while (id != studentArray[FHF].studentId && studentArray[FHF] != null) {
                FHF = FHF + SHF;
                if (id == studentArray[FHF].studentId) {
                    index = FHF;
                    return studentArray[FHF];
                }

            }
            System.out.println("key not found");
            return null;
        }
    }

    public int getIndex(int id) {
        int FHF = firstHashFunction(id);
        int SHF = secondHashFunction(id);
        int counter = 0;
        if (studentArray[FHF] == null || studentArray[FHF].studentId < 0) {
            System.out.println("key is not in the set");
            return -1;
        } else if (studentArray[FHF].studentId == id) {

            return FHF;
        } else {
            while (id != studentArray[FHF].studentId && studentArray[FHF] != null) {
                FHF = FHF + SHF;
                if (id == studentArray[FHF].studentId) {

                    return FHF;
                }

            }
            System.out.println("key not found");
            return -1;
        }
    }
}