package info.dmerej;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SafeCalculatorTest {
  @Test
  void should_not_throw_when_authorized() {
    int right = 1;
    int left = 2;
    Authorizer authorizer = () -> true;
    final SafeCalculator Sc = new SafeCalculator(authorizer);
    assertEquals(Sc.add(left, right), 3);

  }
}
