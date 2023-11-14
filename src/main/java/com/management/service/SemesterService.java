package com.management.service;

import com.management.entity.Semester;
import com.management.repository.SemesterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {

    public final SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }


    public Semester saveSemester (Semester semester) {
        return semesterRepository.save(semester);
    }

    public List<Semester> getAllSemester () {
        return semesterRepository.findAll();
    }

    public Semester getSemesterById (int id) {
        return semesterRepository.findById(id).orElse(null);
    }

    public Semester updateSemester (int id, Semester semester) {
        Semester existingSemester = semesterRepository.findById(id).orElse(null);
        if(existingSemester != null) {
            existingSemester.setName(semester.getName());
            existingSemester.setStart_date(semester.getStart_date());
            existingSemester.setEnd_date(semester.getEnd_date());
            existingSemester.set_active(true);
            return semesterRepository.save(existingSemester);
        }
        return null;
    }

    public String deleteSemester (int id) {
        Semester existingSemester = semesterRepository.findById(id).orElse(null);
        if(existingSemester != null) {
            semesterRepository.deleteById(id);
            return "Delete successful";
        }
        return "Department not found";
    }
}
