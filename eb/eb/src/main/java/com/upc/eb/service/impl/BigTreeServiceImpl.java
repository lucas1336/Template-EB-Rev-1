package com.upc.eb.service.impl;

import com.upc.eb.dto.BigTreeDto;
import com.upc.eb.model.BigTree;
import com.upc.eb.repository.BigTreeRepository;
import com.upc.eb.service.BigTreeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigTreeServiceImpl implements BigTreeService {
    private final BigTreeRepository bigTreeRepository;
    private final ModelMapper modelMapper;

    public BigTreeServiceImpl(BigTreeRepository bigTreeRepository, ModelMapper modelMapper) {
        this.bigTreeRepository = bigTreeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BigTree> listAllBigTrees() {
        return bigTreeRepository.findAll();
    }

    @Override
    public BigTree getBigTree(Long id) {
        return bigTreeRepository.findById(id).orElse(null);
    }

    @Override
    public BigTree create(BigTreeDto bigTree) {
        BigTree bigTreeModel = modelMapper.map(bigTree, BigTree.class);
        return bigTreeRepository.save(bigTreeModel);
    }

    @Override
    public boolean delete(Long id) {
        BigTree bigTree = getBigTree(id);
        if (bigTree == null) {
            return false;
        }
        bigTreeRepository.delete(bigTree);
        return true;
    }

    @Override
    public BigTree update(BigTreeDto bigTree) {
        BigTree bigTreeModel = modelMapper.map(bigTree, BigTree.class);
        return bigTreeRepository.save(bigTreeModel);
    }
}
