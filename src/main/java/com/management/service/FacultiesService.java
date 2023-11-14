package com.management.service;

import com.management.entity.Faculties;
import com.management.repository.FacultiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultiesService {

    @Autowired
    private FacultiesRepository facultiesRepository;

    public Faculties saveFaculty (Faculties faculties) {
        return facultiesRepository.save(faculties);
    }

    public List<Faculties> getAllFaculties () {
        return facultiesRepository.findAll();
    }

    public Faculties getFacultiesbyID (int id) {
        return facultiesRepository.findById(id).orElse(null);
    }

    public Faculties updateFaculties (int id, Faculties faculties) {
        Faculties existingFaculties = facultiesRepository.findById(id).orElse(null);
        if (existingFaculties != null) {
            existingFaculties.setName(faculties.getName());
            existingFaculties.setShort_name(faculties.getShort_name());
            return facultiesRepository.save(existingFaculties);
        }
        return null;
    }

    public String delete ( int id) {
        Faculties existingFaculties = facultiesRepository.findById(id).orElse(null);
        if (existingFaculties != null) {
            facultiesRepository.deleteById(id);
            return "FacultyDeleted"+id;
        }
        return "Faculty not Found.";

    }

}
