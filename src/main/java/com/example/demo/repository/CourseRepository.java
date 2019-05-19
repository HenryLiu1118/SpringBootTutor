package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        Course javaTwo = Course.builder()
                .className("Java II")
                .instructor(new Instructor("Bill", "Gates", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
        courses.add(javaTwo);
    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        List<Course> ans = new ArrayList<Course>();
        courseName = courseName.replace("_"," ");
        for (Course c : courses) {
            if (c.getClassName().equals(courseName)) ans.add(c);
        }

        return ans;
    }

    public void addCourse(String courseName) {
        courseName = courseName.replace(" ","_");
        Course newCourse = Course.builder()
                .className(courseName)
                .instructor(new Instructor("Steve", "Rogers", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();
        this.courses.add(newCourse);
    }

    //update the third course
    public void updateCourse() {
        courses.get(2).setInstructor(Instructor.builder().
                firstName("Tony").
                lastName("Stark").
                title("Phd").
                office("TownHall201").build());
    }

    public void deleteCourse(String courseName) {
        courseName = courseName.replace("_"," ");
        for (Course c : courses) {
            if (c.getClassName().equals(courseName)) {
                courses.remove(c);
                break;
            }
        }
    }
}
