package src.main.java.com.example.Service;

import org.springframework.stereotype.Service;
import test.dto.dto.StudentDto;
import test.dto.entity.StudentEntity;
import test.dto.mapper.StudentMapper;
import test.dto.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public StudentDto create(StudentDto dto) {
        StudentEntity entity = mapper.toEntity(dto);
        StudentEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    public List<StudentDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public Optional<StudentDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public Optional<StudentDto> update(Long id, StudentDto dto) {
        return repository.findById(id).map(existing -> {
            existing.setFirstNameEntity(dto.getFirstNameStudent());
            existing.setLastNameEntity(dto.getLastNameStudent());
            StudentEntity updated = repository.save(existing);
            return mapper.toDto(updated);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
