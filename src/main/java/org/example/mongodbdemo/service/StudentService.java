package org.example.mongodbdemo.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.mongodbdemo.model.Student;
import org.example.mongodbdemo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class StudentService {

    StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Page<Student> getStudentsPage(int pageNumber, int pageSize) {
        return repository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Student insert(Student student) {
        return repository.insert(student);
    }
}
