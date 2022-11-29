package streamExamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestUsers {

    public static void main(String[] args) {

        List<Users> users = Stream.of(new Users("user1", "123", Arrays.asList("123@gmail.com")),
                        new Users("user2", "456", Arrays.asList("456@gmail.com"))).
                collect(Collectors.toList());

        List<String> phoneNumbers = users.stream().map(Users::getPhoneNo).collect(Collectors.toList());

        List<List<String>> emailId = users.stream().map(Users::getEmailId).collect(Collectors.toList());

        // for one to many relations
        List<String> emails = users.stream().flatMap(u -> u.getEmailId().stream()).
                collect(Collectors.toList());

        System.out.println(phoneNumbers);
        System.out.println(emailId);
        System.out.println(emails);

    }
}
