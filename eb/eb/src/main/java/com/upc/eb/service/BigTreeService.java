package com.upc.eb.service;

import com.upc.eb.dto.BigTreeDto;
import com.upc.eb.model.BigTree;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BigTreeService {
    public abstract List<BigTree> listAllBigTrees();
    public abstract BigTree getBigTree(Long id);
    public abstract BigTree create(BigTreeDto bigTree);
    public abstract boolean delete(Long id);
    public abstract BigTree update(BigTreeDto bigTree);
}
