package com.upc.eb.service.impl;

import com.upc.eb.dto.GreenLeafDto;
import com.upc.eb.model.BigTree;
import com.upc.eb.model.GreenLeaf;
import com.upc.eb.repository.BigTreeRepository;
import com.upc.eb.repository.GreenLeafRepository;
import com.upc.eb.service.GreenLeafService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenLeafImpl implements GreenLeafService {
    private final GreenLeafRepository greenLeafRepository;
    private final BigTreeRepository bigTreeRepository;
    private final ModelMapper modelMapper;

    public GreenLeafImpl(GreenLeafRepository greenLeafRepository, BigTreeRepository bigTreeRepository, ModelMapper modelMapper) {
        this.greenLeafRepository = greenLeafRepository;
        this.bigTreeRepository = bigTreeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GreenLeaf> listAllGreenLeafs() {
        return greenLeafRepository.findAll();
    }

    @Override
    public List<GreenLeaf> listAllGreenLeafsByBigTreeId(Long bigTreeId) {
        return greenLeafRepository.findByBigTreeId(bigTreeId);
    }

    @Override
    public GreenLeaf create(GreenLeafDto greenLeaf, Long id) {
        GreenLeaf greenLeafModel = modelMapper.map(greenLeaf, GreenLeaf.class);
        BigTree bigTree = bigTreeRepository.findById(id).orElse(null);
        bigTree.getGreenLeaves().add(greenLeafModel);
        bigTreeRepository.save(bigTree);
        return greenLeafRepository.save(greenLeafModel);
    }
}
