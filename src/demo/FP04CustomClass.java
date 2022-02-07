package demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;
    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getReviewScore() {
        return reviewScore;
    }
    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }
    public int getNoOfStudents() {
        return noOfStudents;
    }
    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                "category='" + category + '\'' +
                "reviewScore='" + reviewScore + '\'' +
                "noOfStudents='" + noOfStudents + '\'' +
                '}';
    }
}
public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        //check review score greater than 90
        boolean review90 = courses.stream()
                .allMatch(e -> e.getReviewScore()>90);
        System.out.println(review90);
        //noneMatch - none of courses should pass predicate
        boolean reviewLessThan90 = courses.stream()
                .noneMatch(e -> e.getReviewScore()<90);
        System.out.println(reviewLessThan90);
        //anyMatch - any course match predicate

        //Comparator
        Comparator<Course> compareByNoOfStudents = Comparator.comparing(Course::getNoOfStudents).reversed();
        // Sort by No of students
        List<Course> courseList = courses.stream()
                .sorted(compareByNoOfStudents)
                .collect(Collectors.toList());
//        System.out.println(courseList);

        Comparator<Course> compareByNoOfStudentsAndReviews = Comparator.comparing(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();

        List<Course> courseList2 = courses.stream()
                .sorted(compareByNoOfStudentsAndReviews)
                .limit(5)
//                .skip(3) // skip first 3
                .collect(Collectors.toList());
//        System.out.println(courseList2);

        // Return all courses unil score 95. All courses after which has +95 is not returned
        List<Course> courseList3 = courses.stream()
                .takeWhile(course -> course.getReviewScore()>=95)
//                .dropWhile(course -> course.getReviewScore()>=95) // opp
                .collect(Collectors.toList());
        System.out.println(courseList3);







    }
}
