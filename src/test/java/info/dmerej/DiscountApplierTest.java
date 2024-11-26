package info.dmerej;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountApplierTest {
  class NotifierTestImplementation implements Notifier {
    private final List<User> notifiedUsers = new ArrayList<>();

    @Override
    public void notify(User user, String message) {
      notifiedUsers.add(user);
    }

    public List<User> getNotifiedUsers() {
      return notifiedUsers;
    }
  }
  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    NotifierTestImplementation notifier = new NotifierTestImplementation();
    DiscountApplier discountApplier = new DiscountApplier(notifier);
    List<User> users = new ArrayList<>();
    users.add(new User("Luc", "luc@gmail.com"));
    users.add(new User("Bastien", "bastien@gmail.com"));


    discountApplier.applyV1(20, users);

    assertEquals(2, notifier.getNotifiedUsers().size());
  }



  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v2() {
    NotifierTestImplementation notifier = new NotifierTestImplementation();
    DiscountApplier discountApplier = new DiscountApplier(notifier);
    List<User> users = new ArrayList<>();
    users.add(new User("Luc", "luc@gmail.com"));
    users.add(new User("Bastien", "bastien@gmail.com"));


    discountApplier.applyV2(20, users);

    assertEquals("Bastien", notifier.getNotifiedUsers().get(1).name());
    // TODO: write a test to demonstrate the bug in DiscountApplier.applyV2()
  }

}
