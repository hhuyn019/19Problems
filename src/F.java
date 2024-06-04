import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class F {
    public static void main(String[] args) {
        program1();
        program2();
        program3();
        program4();
        program5();
        program6();
        program7();
        program8();
        program9();
        program10();
        program11();
        program12();
        program13();
        program14();
        program15();
        program16();
        program17();
        program18();
        program19();
    }

    //Write a Java program that uses the Stream API to filter out all even numbers from a list of integers.
    public static void program1() {
        List<Integer> myList = Arrays.asList(12,543,6,1,54,1,43);
        List<Integer> results = myList.stream().filter(a->a%2!=0).collect(Collectors.toList());
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to convert a list of strings to uppercase.
    public static void program2() {
        List<String> myList = Arrays.asList("abc","FqW","1Vx","oop");
        List<String> results = myList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to find the sum of all elements in a list of integers.
    public static void program3() {
        List<Integer> myList = Arrays.asList(12,543,6,1,54,1,43);
        Integer results = myList.stream().reduce(Integer::sum).get();
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to collect all distinct elements from a list of integers into a set.
    public static void program4() {
        List<Integer> myList = Arrays.asList(12,543,6,1,54,1,43,12,6,124,71,45,54);
        Set<Integer> results = myList.stream().distinct().collect(Collectors.toSet());
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to filter a list of strings that start with the letter "A" and collect them into a list.
    public static void program5() {
        List<String> myList = Arrays.asList("apple","banana","orange","apricot","watermelon","strawberry","lemon","Asparagus");
        List<String> results = myList.stream().filter(a->a.startsWith("a")||a.startsWith("A")).collect(Collectors.toList());
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to find the maximum value in an array of integers.
    public static void program6() {
        List<Integer> myList = Arrays.asList(12,543,6,1,54,1,43,12,6,124,71,45,54);
        Integer result = myList.stream().reduce(Integer::max).get();
        System.out.println(result);
    }

    //Write a Java program that uses the Stream API to sort a list of strings alphabetically.
    public static void program7() {
        List<String> myList = Arrays.asList("apple","banana","orange","apricot","watermelon","strawberry","lemon","Asparagus");
        List<String> results = myList.stream().sorted().collect(Collectors.toList());
        System.out.println(results);
    }

    //Write a Java program that uses a parallel stream to process a large list of integers and find their average.
    public static void program8() {
        List<Integer> myList = Arrays.asList(12,543,6,1,54,1,43,12,6,124,71,45,54);
        int size = myList.size();
        Double sum = myList.parallelStream().reduce(Integer::sum).get().doubleValue();
        System.out.println(sum/size);
    }

    //Write a Java program that uses the Stream API to filter a list of Person objects (having fields name and age) to find all people older than 25.
    public static void program9() {
        List<Person> myList = new ArrayList<>();
        myList.add(new Person("A",22));
        myList.add(new Person("B",27));
        myList.add(new Person("C",25));
        myList.add(new Person("D",24));
        myList.add(new Person("E",29));
        List<Person> results = myList.stream().filter(a->a.getAge()>25).collect(Collectors.toList());
        for(Person p:results) System.out.println(p.getName() + " " + p.getAge());
    }

    //Write a Java program that uses the Stream API to group a list of Person objects by age.
    public static void program10() {
        List<Person> myList = new ArrayList<>();
        myList.add(new Person("A",22));
        myList.add(new Person("B",27));
        myList.add(new Person("C",25));
        myList.add(new Person("D",24));
        myList.add(new Person("E",29));
        myList.add(new Person("F",29));
        myList.add(new Person("G",25));

        Map<Integer, List<Person>> map = myList.stream().collect(Collectors.groupingBy(a->a.getAge()));
        for(Integer key:map.keySet()) {
            System.out.println(key + map.get(key).toString());
        }
    }

    //Write a Java program that uses the Stream API to partition a list of integers into odd and even numbers.
    public static void program11() { //???
        List<Integer> myList = Arrays.asList(12,543,6,1,54,1,43,12,6,124,71,45,54);
        Map<Boolean, List<Integer>> groups = myList.stream().collect(Collectors.groupingBy(a->a%2==0));
        List<Integer> results = Stream.of(groups.get(false),groups.get(true)).flatMap(list->list.stream()).collect(Collectors.toList());
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to join a list of strings with a comma separator.
    public static void program12() {
        List<String> myList = Arrays.asList("apple","banana","orange","apricot","watermelon","strawberry","lemon","Asparagus");
        int size = myList.size();
        System.out.println(myList.stream().map(a-> a.equals(myList.get(size-1))?a+"":a+", ").reduce(String::concat).get());
    }

    //Write a Java program that uses the Stream API to flatten a list of lists of integers into a single list of integers.
    public static void program13() {
        List<Integer> list1 = Arrays.asList(13,5,213);
        List<Integer> list2 = Arrays.asList(52,41,1);
        List<Integer> list3 = Arrays.asList(11,85,472);
        List<List<Integer>> bigList = Arrays.asList(list1,list2,list3);
        List<Integer> results = bigList.stream().flatMap(list->list.stream()).collect(Collectors.toList());
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to find the average, maximum, and minimum values of a list of integers.
    public static void program14() {
        List<Integer> myList = Arrays.asList(12,543,6,1,54,1,43,12,6,124,71,45,54);
        Double average = myList.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        Integer min = myList.stream().reduce(Integer::min).get();
        Integer max = myList.stream().reduce(Integer::max).get();
        System.out.println("Average: " + average + " min: " + min + " max: " + max);
    }

    //Write a Java program that uses the Stream API to generate a stream of 10 random integers.
    public static void program15() {
        List<Integer> myList = new Random().ints(0,1000).limit(10).boxed().collect(Collectors.toList());
        System.out.println(myList);
    }

    //Write a Java program that uses the Stream API to generate an infinite stream of integers starting from 1 and find the first 10 prime numbers
    public static void program16() {
        List<Integer> myList = IntStream.iterate(0,i->i+1).boxed().filter(a->{
            if(a==2) {
                return true;
            }
            if(a==0 || a==1) {
                return false;
            }
            for(int i = 2; i <= a/2; ++i) {
                if(a%i==0) {
                    return false;
                }
            }
            return true;
        }).limit(10).collect(Collectors.toList());
        System.out.println(myList);
    }

    //Write a Java program that uses the Stream API to skip the first 5 elements of a list and then collect the next 5 elements.
    public static void program17() {
        List<Integer> myList = Arrays.asList(12,543,6,1,54,1,43,12,6,124,71,45,54);
        List<Integer> results = myList.stream().skip(5).limit(5).collect(Collectors.toList());
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to find all distinct strings in a list, ignoring case sensitivity.
    public static void program18() {
        List<String> myList = Arrays.asList("abc", "ABC", "aBc", "qWe", "abcd", "qwerty", "qw", "ab", "abc");
        Set<String> results = myList.stream().map(String::toLowerCase).distinct().collect(Collectors.toSet());
        System.out.println(results);
    }

    //Write a Java program that uses the Stream API to print each element of a list of strings before collecting them into a new list.
    public static void program19() {
        List<String> myList = Arrays.asList("apple","banana","orange","apricot","watermelon","strawberry","lemon","Asparagus");
        //System.out.println(myList.stream().collect(Collectors.toList()));
        List<String> newList = myList.stream().peek(s-> System.out.println(s)).collect(Collectors.toList());
    }
}
