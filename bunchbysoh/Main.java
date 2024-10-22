package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    double rated_capacity=120.0;
    for(int capacity:presentCapacities)
    {
      double soh=(capacity/rated_capacity)*100.0;
      if (soh>83.0 && soh<=100.0)
      {
        counts.healthy++;
      }
      else if (soh>=63.0 && soh<=83.0)
      {
        counts.exchange++;
      }
      else
      {
        counts.failed++;
      }

    }
    return counts;
  }


  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70, 56};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    System.out.println("Healthy: " + counts.healthy);
    System.out.println("Exchange: " + counts.exchange);
    System.out.println("Failed: " + counts.failed);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
