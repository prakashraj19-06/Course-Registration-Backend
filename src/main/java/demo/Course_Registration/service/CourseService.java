package demo.Course_Registration.service;

import demo.Course_Registration.model.Course;
import demo.Course_Registration.model.CourseRegistry;
import demo.Course_Registration.repository.CourseRegistryRepo;
import demo.Course_Registration.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course addCourses(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> availableCourses() {
        return courseRepository.findAll();
    }

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public CourseRegistry addEnroll(CourseRegistry course) {
        return courseRegistryRepo.save(course);
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry =new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo.save(courseRegistry);

    }

    public void deleteEnrolledStudent(int id) {
        courseRegistryRepo.deleteById(id);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourses(String courseId) {
      courseRepository.deleteById(courseId);
    }
}
