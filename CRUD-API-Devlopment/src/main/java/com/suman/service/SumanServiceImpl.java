package com.suman.service;

import com.suman.entity.SumanCRUD;
import com.suman.payload.SumanDTO;
import com.suman.repository.SumanCRUDRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SumanServiceImpl implements SumanService {
    private SumanCRUDRepository sumanCRUDRepository;

    public SumanServiceImpl(SumanCRUDRepository sumanCRUDRepository) {
        this.sumanCRUDRepository = sumanCRUDRepository;
    }

    @Override
    public SumanDTO createStudent(SumanDTO sumanDto) {
        SumanCRUD sumanCRUD=mapToEntity(sumanDto);
        SumanCRUD saveEntity=sumanCRUDRepository.save(sumanCRUD);
        SumanDTO dto =mapToDTO(saveEntity);
        return dto;
    }
    SumanCRUD mapToEntity(SumanDTO sumanDto){
        SumanCRUD entity = new SumanCRUD();
        entity.setName(sumanDto.getName());
        entity.setEmail(sumanDto.getEmail());
        entity.setMobile(sumanDto.getMobile());
        return entity;
    }
    SumanDTO mapToDTO(SumanCRUD sumanCRUD){
        SumanDTO dto = new SumanDTO();
        dto.setId(sumanCRUD.getId());
        dto.setName(sumanCRUD.getName());
        dto.setEmail(sumanCRUD.getEmail());
        dto.setMobile(sumanCRUD.getMobile());
        return dto;
    }

    @Override
    public List<SumanDTO> listOfStudent(int pageNo,int pageSize,String sortBy,String sortDir) {
       Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<SumanCRUD> all = sumanCRUDRepository.findAll(pageable);
        List<SumanCRUD> content = all.getContent();
        List<SumanDTO> collect = content.stream().map(e -> mapToDTO(e)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public SumanDTO updateStudentDetail(SumanDTO sumanDTO, long id) {
        Optional<SumanCRUD> byId = sumanCRUDRepository.findById(id);
       SumanCRUD sumanCRUD = byId.get();
       sumanCRUD.setName(sumanDTO.getName());
       sumanCRUD.setMobile(sumanDTO.getMobile());
       sumanCRUD.setEmail(sumanDTO.getEmail());
       SumanCRUD saveEntity = sumanCRUDRepository.save(sumanCRUD);
       SumanDTO dto = mapToDTO(saveEntity);
        return dto;
    }

    @Override
    public void deleteStudentById(long id) {

    }
}
