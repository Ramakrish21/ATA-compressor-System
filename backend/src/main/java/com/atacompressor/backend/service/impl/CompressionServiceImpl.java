package com.atacompressor.backend.service.impl;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.atacompressor.backend.dto.request.CompressionRequest;
import com.atacompressor.backend.dto.response.CompressionResponse;
import com.atacompressor.backend.entity.CompressionRecord;
import com.atacompressor.backend.repository.CompressionRepository;
import com.atacompressor.backend.service.CompressionService;

@Service
public class CompressionServiceImpl implements CompressionService {

    private final CompressionRepository compressionRepository;

    public CompressionServiceImpl(CompressionRepository compressionRepository) {
        this.compressionRepository = compressionRepository;
    }

    public CompressionResponse compressText(CompressionRequest request){

        String originalText = request.getOriginalText();
        String taskType = request.getTaskType();


        int originalLength = originalText != null ? originalText.length() : 0;  // Original content cal, length

        String compressedText = originalText;  // Dummy content 

        int compressedLength = compressedText != null ? compressedText.length() : 0; // compressed content cal. length

        Double compressionRatio = originalLength > 0
        ? ((double) (originalLength - compressedLength) / originalLength) * 100
        : 0.0;


        CompressionRecord record = new CompressionRecord();
        record.setOriginalText(originalText);
        record.setCompressedText(compressedText);
        record.setTaskType(taskType);
        record.setOriginalLength(originalLength);
        record.setCompressedLength(compressedLength);
        record.setCompressionRatio(compressionRatio);
        record.setStatus("SUCCESS");
        record.setCreatedAt(LocalDateTime.now());
        record.setUpdatedAt(LocalDateTime.now());

        CompressionRecord savedRecord = compressionRepository.save(record);


        return new CompressionResponse(savedRecord.getId(),
                savedRecord.getOriginalText(),
                savedRecord.getCompressedText(),
                savedRecord.getTaskType(),
                savedRecord.getOriginalLength(),
                savedRecord.getCompressedLength(),
                savedRecord.getCompressionRatio(),
                savedRecord.getStatus(),
                savedRecord.getCreatedAt());
    }

    @Override
    public List<CompressionResponse> getAllCompressions(){

        return compressionRepository.findAll()
                .stream()
                .map(record -> new CompressionResponse(
                        record.getId(),
                        record.getOriginalText(),
                        record.getCompressedText(),
                        record.getTaskType(),
                        record.getOriginalLength(),
                        record.getCompressedLength(),
                        record.getCompressionRatio(),
                        record.getStatus(),
                        record.getCreatedAt()
                ))
                .collect(Collectors.toList());
        
    }

    @Override
    public CompressionResponse getCompressionById(Long id) {
        CompressionRecord record = compressionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compression record not found with id: " + id));

        return new CompressionResponse(
                record.getId(),
                record.getOriginalText(),
                record.getCompressedText(),
                record.getTaskType(),
                record.getOriginalLength(),
                record.getCompressedLength(),
                record.getCompressionRatio(),
                record.getStatus(),
                record.getCreatedAt()
        );
    }

    @Override
    public void deleteCompressionById(Long id) {
        if (!compressionRepository.existsById(id)) {
            throw new RuntimeException("Compression record not found with id: " + id);
        }
        compressionRepository.deleteById(id);
    }

}
