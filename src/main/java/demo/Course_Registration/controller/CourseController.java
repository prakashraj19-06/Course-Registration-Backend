package demo.Course_Registration.controller;

import demo.Course_Registration.model.Course;
import demo.Course_Registration.model.CourseRegistry;
import demo.Course_Registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://courses-registration-system.netlify.app")
public class CourseController {

    @Autowired
    CourseService courseService;

    //ME-mannual data entry using postMan
    //Course Table
    @PostMapping("/create")
    public Course addCourses(@RequestBody Course course){
        return courseService.addCourses(course);
    }

    @GetMapping("/courses")
    public List<Course> availableCourses(){
        return courseService.availableCourses();
    }

    @PutMapping("/courses/update")
    public String updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
        return "update successfull !!";
    }

    @DeleteMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable String id){
        courseService.deleteCourses(id);
        return "delete successfuly";
    }

    //ME
    //Course register student Table
    @PostMapping("/enrollNow")
    public CourseRegistry addEnroll(@RequestBody CourseRegistry course){
        return courseService.addEnroll(course);
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents() {
        return courseService.enrolledStudents();
    }

    //get data from frontend
    @PostMapping("/courses/register")
    public void enrollCourse(@RequestParam("name") String name,
                              @RequestParam("emailId") String emailId,
                              @RequestParam("courseName") String courseName){
        courseService.enrollCourse(name,emailId,courseName);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteEnrolledStudent(@PathVariable int id){
        courseService.deleteEnrolledStudent(id);
    }
}
