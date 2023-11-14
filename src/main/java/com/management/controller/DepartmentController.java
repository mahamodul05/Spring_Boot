package com.management.controller;

import com.management.entity.Department;
import com.management.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DepartmentController {
    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public ResponseEntity<Map<String, List<Department>>> getAllDepartment() {
        List<Department> department = departmentService.getAllDepartment();
        Map<String, List<Department>> responseMap = new HashMap<>();
        responseMap.put("data", department);
        return ResponseEntity.ok(responseMap);
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentByID(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable int id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable int id) {
        return departmentService.deleteDepartment(id);
    }



}
