public class Permutation {
  public static void main(String[] args) {
    //initialize needed variables
    int size = args.length;
    int[] vector = new int[size];
    int max_num = size - 1;

    // parse command line arguments
    for (int i=0; i<size; i++) {
      try {
        vector[i] = Integer.parseInt(args[i]);
      }
      catch (Exception e) {
        System.out.println("Exception: " + e);
      }
    }

    // initialize the result
    int[] result = new int[size];

    for (int i=0; i<size; i++) {
      result[i] = 0;
    }

    // calculate the permutation
    for (int i=0; i<size; i++) {
      result[i] = max_num - vector[i];

      for (int j=0; j<i; j++) {
        if (result[j] <= result[i]) {
          result[j]--;
        }
      }
    }

    // check for errors
    for (int i=0; i<size; i++) {
      if (result[i]+1==0 || result[i]>max_num) {
        System.out.println("There might be something wrong with your vector ");
        return;
      }
    }

    // print the result
    for (int i=0; i<size; i++) {
      System.out.println((i+1) + " - " + (result[i]+1));
    }
  }
}
