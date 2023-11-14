package com.management.service;


import com.management.entity.Department;
import com.management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment (Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartment () {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById (int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartment (int id, Department department) {
        Department existingDept = departmentRepository.findById(id).orElse(null);
        if(existingDept != null) {
            existingDept.setName(department.getName());
            existingDept.setShort_name(department.getShort_name());
            return departmentRepository.save(existingDept);
        }
        return null;
    }

    public String deleteDepartment (int id) {
        Department existingDept = departmentRepository.findById(id).orElse(null);
        if(existingDept != null) {
            departmentRepository.deleteById(id);
            return "Delete successful";
        }
        return "Department not found";
    }


}
