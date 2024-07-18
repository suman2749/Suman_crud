package com.suman.controller;

import com.suman.payload.SumanDTO;
import com.suman.service.SumanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suman/registration")
public class SumanController {
    private SumanService sumanService;

    public SumanController(SumanService sumanService) {
        this.sumanService = sumanService;
    }
    @PostMapping
    public ResponseEntity<SumanDTO>addNewStudent(@RequestBody SumanDTO sumanDTO){
        SumanDTO dto=sumanService.createStudent(sumanDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<SumanDTO>>listStudent(
            @RequestParam(name="pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(name="pageSize",defaultValue = "5",required = false)int pageSize,
            @RequestParam(name="sortBy",defaultValue = "name",required = false)String sortBy,
            @RequestParam(name="sortDir",defaultValue = "name",required = false)String sortDir
    ){
        List<SumanDTO> sumanDTOS = sumanService.listOfStudent(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(sumanDTOS,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<SumanDTO>updateTheStudent(@RequestBody SumanDTO sumanDTO,@RequestParam long id){
        SumanDTO sumanDTO1 = sumanService.updateStudentDetail(sumanDTO,id);
        return new ResponseEntity<>(sumanDTO1,HttpStatus.OK);
    }

}