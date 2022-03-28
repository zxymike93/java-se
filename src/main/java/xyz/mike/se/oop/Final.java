package xyz.mike.se.oop;

import java.util.AbstractCollection;

public class Final {
  public static void main(String[] args) {
    // FinalField.NAME = "Michael";
  }
}

// Can not be extends
final class FinalClass {}

// class Test extends FinalClass {}

class FinalMethod {
  // Can not be overrides
  public final void hi() {}
}

// class FinalMethodTest extends FinalMethod {
//   @Override
//   public void hi() {}
// }

class FinalField {
  // Can not be modified
  public static final String NAME = "Mike";
}

class FinalVariable {
  public static void test() {
    // Can not be modified
    final double N = 0.01;
    // N = 0.02;
  }
}