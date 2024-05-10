//public class HashTable {
//     LinkyListy [] idHashTable;
//   public HashTable(int size){
//       if(size <= 1000){
//           //create array of size 1009
//           idHashTable = new LinkyListy [1009];
//       }
//        if(size <= 500){
//            //create array of size 501
//            idHashTable = new LinkyListy [501];
//
//        }
//       if(size <= 250){
//           //create array of size 251
//           idHashTable = new LinkyListy [251];
//
//       }
//       if(size <= 100){
//           //create array of size 101
//           idHashTable = new LinkyListy [101];
//
//       }
//       if(size <= 50){
//           //create array of size 53
//           idHashTable = new LinkyListy [53];
//
//       }
//   }
//
//   public int firstHashFunction(long id){
//       return  Math.abs((int)(id%(this.idHashTable.length)));
//   }
//   public int secondHashFunction(long id){
//       final int C = 17;
//       // Perform a different type of hashing, e.g., a different prime multiplier
//       int hash = (int) (((id * C) + 1) % this.idHashTable.length);
//       // Ensure non-negative result
//       hash = (hash < 0) ? (hash + this.idHashTable.length) : hash;
//       // Ensure that the second hash function never returns 0
//       return (hash == 0) ? 1 : hash;
//   }
//
//
//   //********************************************************
//    // I need to creat a function that takes the linked list --> save its objects into an array -> i need a way to get the student id
//    // and store the object address in an index inside the array used by the hashmap
////   public long [] addAll(LinkyListy l){
//////        this.idHashTable[firstHashFunction(Node.getStudentId())] = Node.getStudentId();
////       if(l.head ==  null){
////           System.out.println("there is a problem with addAll function or linkedList is pointing to null");
////           return null;
////       }
////       else{
////
////       }
////
////    return null;
////   }
//    public Object [] addAll(LinkyListy l){
//       if(l.pushNode() != null){
//           LinkyListy.Node a = l.pushNode();
//           int index = firstHashFunction(l.getStudentId(a));
//
//           if(null == idHashTable[index] || idHashTable[index].getStudentId(a) < 0){
//                idHashTable[index] = a;
//           }
//           else{
//               while(null != idHashTable[index]){
//                   index = index + secondHashFunction(l.getStudentId(a));
//               }
//               idHashTable[index] = a;
//           }
//       }
//       return idHashTable;//******************check this line might need work
//    }
//
//
//}
