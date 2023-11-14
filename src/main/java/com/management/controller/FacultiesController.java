package com.management.controller;

import com.management.entity.Faculties;
import com.management.service.FacultiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FacultiesController {
    private final FacultiesService facultiesService;

    public FacultiesController(FacultiesService facultiesService) {
        this.facultiesService = facultiesService;
    }

    @PostMapping("/faculty")
    public Faculties addFaculties (@RequestBody Faculties faculties) {
        System.out.println(faculties.getName());
        System.out.println(faculties.getShort_name());
        return facultiesService.saveFaculty(faculties);
    }

    @GetMapping("/faculty/{id}")
    public Faculties findFacultyById (@PathVariable int id) {
          return facultiesService.getFacultiesbyID(id);
    }

    @GetMapping("/faculty")
    public ResponseEntity<Map<String, List<Faculties>>> getAllFaculties() {
        List<Faculties> faculties = facultiesService.getAllFaculties();
        Map<String, List<Faculties>> responseMap = new HashMap<>();
        responseMap.put("data", faculties);
        return ResponseEntity.ok(responseMap);
    }


    @PutMapping("/faculty/{id}")
    public Faculties updateFaculties (@PathVariable int id, @RequestBody Faculties faculties) {
        return facultiesService.updateFaculties(id, faculties);
    }

    @DeleteMapping("/faculty/{id}")
    public String deleteFaculty (@PathVariable int id) {
        return facultiesService.delete(id);
    }



}
