package edu.cnm.deepdive;

import java.util.Comparator;

public class TopLevel { // the only top level public class

  private int data = 10; // public static class can't see this because it's not static
  private static int moreData = 100; // can be seen in static classes

  public static class NestedClass  { // static class

    private int myData = moreData; // can see moreData because it's static since the class it is in is static

  }

  public class InnerClass {

    private int myData = data; // can see data because it's not a static class

    private  void doSomething() {
      System.out.println(TopLevel.this.getClass().getSimpleName()); // prints out TopLevel not inner class

      Comparator<Integer> comp = new Comparator<Integer>() { // anonymous class as interface implementations
        @Override
        public int compare(Integer val1, Integer val2) {
          return Integer.compare(val1, val2);
        }
      };

      // anonymous class as subclass
      Object obj = new Object() {

      };

      class LocalClass {

      }
      // local class
      LocalClass lc = new LocalClass();

      Comparator<Integer> comp2 = (val1, val2) -> {
        System.out.println(this.getClass().getSimpleName());
        Integer.compare(val1, val2);
      }
    }

  }

}

//public class TopLevel2 {
//                                can't have another top level class
//}