public class Exceptions {
  // Custom exception class
  class TryException extends Exception {
  }

  // Method that randomly throws exceptions or succeeds
  void tryMe() throws TryException {
    if (Math.random() > 0.5) {
      return; // Success
    }
    if (Math.random() > 0.25) {
      throw new TryException(); // Custom failure exception
    }
    throw new RuntimeException(); // Unchecked error
  }

  // Method that calls tryMe()
  void nestedTry() throws TryException {
    tryMe();
  }

  // Main method
  public static void main(String[] args) {
    Exceptions example = new Exceptions();

    int attempts = 0, successes = 0, failures = 0, errors = 0;

    String report = "Attempts: %s; Successes: %s; Failures: %s; Errors: %s%n";

    // First loop - Direct calls to tryMe()
    for (int i = 0; i < 1000; i++) {
      attempts++;
      try {
        example.tryMe();
        successes++;
      } catch (TryException e) {
        failures++;
      } catch (Exception e) {
        errors++;
      }
    }

    // Output results for direct calls
    System.out.format(report, attempts, successes, failures, errors);

    // Reset counters
    attempts = successes = failures = errors = 0;

    // Second loop - Calls using nestedTry()
    for (int i = 0; i < 1000; i++) {
      attempts++;
      try {
        example.nestedTry();
        successes++;
      } catch (TryException e) {
        failures++;
      } catch (Exception e) {
        errors++;
      }
    }

    // Output results for nested calls
    System.out.format(report, attempts, successes, failures, errors);
  }
}
