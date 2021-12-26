package telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        String regex = "^[0-9]+$";

            for (String number : numbers) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(number);

                if (matcher.find()) {
                    sb.append("Calling... ").append(number)
                            .append(System.lineSeparator());
                } else {
                    sb.append("Invalid number!").append(System.lineSeparator());
                }
            }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        String regex = "\\b(http://[a-z]+[.][a-z]+)\\b";

        for (String sites : urls) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sites);

            if (matcher.find()) {
                sb.append("Browsing: ").append(sites).append("!")
                        .append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
