package com.atacompressor.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atacompressor.backend.dto.request.CompressionRequest;
import com.atacompressor.backend.dto.response.CompressionResponse;
import com.atacompressor.backend.service.CompressionService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/compressions")
@CrossOrigin(origins = "http://localhost:5173")
public class CompressionController {

    private final CompressionService compressionService;

    public CompressionController(CompressionService compressionService) {
        this.compressionService = compressionService;
    }

    @PostMapping
    public ResponseEntity<CompressionResponse> compressText(@RequestBody CompressionRequest request){
        CompressionResponse response = compressionService.compressText(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<CompressionResponse>> getAllCompressions(){
        List<CompressionResponse> responses = compressionService.getAllCompressions();

        return new ResponseEntity<>(responses, HttpStatus.OK);

    } 

       @GetMapping("/{id}")
    public ResponseEntity<CompressionResponse> getCompressionById(@PathVariable Long id) {
        CompressionResponse response = compressionService.getCompressionById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompressionById(@PathVariable Long id) {
        compressionService.deleteCompressionById(id);
        return new ResponseEntity<>("Compression record deleted successfully", HttpStatus.OK);
    }

}
