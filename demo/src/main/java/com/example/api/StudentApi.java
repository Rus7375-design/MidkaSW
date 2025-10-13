package src.main.java.com.example.api;
package test.dto.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

import test.dto.dto.StudentDto;
import test.dto.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentApi {
    private final StudentService service;

    public StudentApi(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto dto) {
        StudentDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/students/" + created.getId())).body(created);
    }

    @GetMapping
    public List<StudentDto> getAll() { return service.getAll(); }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @RequestBody StudentDto dto) {
        return service.update(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
