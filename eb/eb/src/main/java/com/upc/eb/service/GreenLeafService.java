package com.upc.eb.service;

import com.upc.eb.dto.GreenLeafDto;
import com.upc.eb.model.GreenLeaf;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GreenLeafService {
    public abstract List<GreenLeaf> listAllGreenLeafs();
    public abstract List<GreenLeaf> listAllGreenLeafsByBigTreeId(Long bigTreeId);
    public abstract GreenLeaf create(GreenLeafDto greenLeaf, Long id);
}
