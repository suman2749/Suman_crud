package com.suman.service;

import com.suman.payload.SumanDTO;

import java.util.List;

public interface SumanService {
    public SumanDTO createStudent(SumanDTO studentDto);

    public List<SumanDTO> listOfStudent(int pageNo,int pageSize,String sortBy,String SortDir);

    public SumanDTO updateStudentDetail(SumanDTO sumanDTO,long id);

    public void deleteStudentById(long id);
}
