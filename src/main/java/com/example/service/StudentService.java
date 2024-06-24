package com.example.service;

	import org.springframework.stereotype.Service;
	import com.example.entity.Student;
	import com.example.repository.StudentRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import java.util.List;
	import java.util.Optional;

	@Service
	public class StudentService {

	    @Autowired
	    private StudentRepository studentRepository;

	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    public Optional<Student> getStudentById(Long id) {
	        return studentRepository.findById(id);
	    }

	    public Student saveStudent(Student student) {
	        return studentRepository.save(student);
	    }

	    public Student updateStudent(Long id, Student studentDetails) {
	        Student student = studentRepository.findById(id).orElseThrow();
	        student.setName(studentDetails.getName());
	        student.setAge(studentDetails.getAge());
	        student.setCourse(studentDetails.getCourse());
	        return studentRepository.save(student);
	    }

	    public void deleteStudent(Long id) {
	        studentRepository.deleteById(id);
	    }
	

}
