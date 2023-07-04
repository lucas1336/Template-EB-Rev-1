package com.upc.eb.controller;

import com.upc.eb.dto.BigTreeDto;
import com.upc.eb.model.BigTree;
import com.upc.eb.service.BigTreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class BigTreeController {
    private final BigTreeService bigTreeService;

    public BigTreeController(BigTreeService bigTreeService) {
        this.bigTreeService = bigTreeService;
    }

    // URL: http://localhost:8080/api/trees
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<BigTree>> getAllTrees() {
        return new ResponseEntity<List<BigTree>>(bigTreeService.listAllBigTrees(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/trees/{treeId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/{treeId}")
    public ResponseEntity<BigTree> getBigTree(@PathVariable(name = "treeId") Long treeId) {
        return new ResponseEntity<BigTree>(bigTreeService.getBigTree(treeId), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/trees
    // Method: POST
    @Transactional
    @PostMapping
    public ResponseEntity<BigTree> createBigTree(@RequestBody BigTreeDto bigTree) {
        return new ResponseEntity<BigTree>(bigTreeService.create(bigTree), HttpStatus.CREATED);
    }

    // URL: http://localhost:8080/api/trees/{treeId}
    // Method: DELETE
    @Transactional
    @DeleteMapping("/{treeId}")
    public ResponseEntity<BigTree> deleteBigTree(@PathVariable(name = "treeId") Long treeId) {
        bigTreeService.delete(treeId);
        return new ResponseEntity<BigTree>(HttpStatus.NO_CONTENT);
    }
}
