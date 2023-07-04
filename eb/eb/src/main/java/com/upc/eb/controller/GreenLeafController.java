package com.upc.eb.controller;

import com.upc.eb.dto.GreenLeafDto;
import com.upc.eb.model.GreenLeaf;
import com.upc.eb.service.GreenLeafService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class GreenLeafController {
    private final GreenLeafService greenLeafService;

    public GreenLeafController(GreenLeafService greenLeafService) {
        this.greenLeafService = greenLeafService;
    }

    // URL: http://localhost:8080/api/trees/leafs
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/leafs")
    public ResponseEntity<List<GreenLeaf>> getAllLeafs() {
        return new ResponseEntity<List<GreenLeaf>>(greenLeafService.listAllGreenLeafs(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/trees/{treeId}/leafs
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/{treeId}/leafs")
    public ResponseEntity<List<GreenLeaf>> getAllLeafs(@PathVariable(name = "treeId") Long treeId) {
        return new ResponseEntity<List<GreenLeaf>>(greenLeafService.listAllGreenLeafsByBigTreeId(treeId), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/trees/{treeId}/leafs
    // Method: POST
    @Transactional
    @PostMapping("/{treeId}/leafs")
    public ResponseEntity<GreenLeaf> createGreenLeaf(@PathVariable(name = "treeId") Long treeId, @RequestBody GreenLeafDto greenLeaf) {
        return new ResponseEntity<GreenLeaf>(greenLeafService.create(greenLeaf, treeId), HttpStatus.CREATED);
    }
}
