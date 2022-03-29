package xyz.mike.se.pattern;

public class Singleton {
  public static void main(String[] args) {
    Wife wife = Wife.getInstance();
  }
}

class Wife {
  private static Wife wife = new Wife();
  String name;

  public static Wife getInstance() {
    return wife;
  }
}
