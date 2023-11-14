package com.management.controller;


import com.management.entity.Semester;
import com.management.service.SemesterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SemesterController {
    public final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping("/semester")
    public Semester addSemester(@RequestBody Semester semester) {
        return semesterService.saveSemester(semester);
    }

    @GetMapping("/semester")
    public ResponseEntity<Map<String, List<Semester>>> getAllSemester() {
        List<Semester> semesters = semesterService.getAllSemester();
        Map<String, List<Semester>> responseMap = new HashMap<>();
        responseMap.put("data", semesters);
        return ResponseEntity.ok(responseMap);
    }

    @GetMapping("/semester/{id}")
    public Semester getSemesterByID(@PathVariable int id) {
        return semesterService.getSemesterById(id);
    }

    @PutMapping("/semester/{id}")
    public Semester updateSemester(@PathVariable int id, @RequestBody Semester semester) {
        return semesterService.updateSemester(id, semester);
    }

    @DeleteMapping("/semester/{id}")
    public String deleteSemester(@PathVariable int id) {
        return semesterService.deleteSemester(id);
    }



}
