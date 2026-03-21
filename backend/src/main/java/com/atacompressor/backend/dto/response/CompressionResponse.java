package com.atacompressor.backend.dto.response;

import java.time.LocalDateTime;

public class CompressionResponse {

    private Long id;
    private String originalText;
    private String compressedText;
    private String taskType;
    private Integer originalLength;
    private Integer compressedLength;
    private Double compressionRatio;
    private String status;
    private LocalDateTime createdAt;

    public CompressionResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getCompressedText() {
        return compressedText;
    }

    public void setCompressedText(String compressedText) {
        this.compressedText = compressedText;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Integer getOriginalLength() {
        return originalLength;
    }

    public void setOriginalLength(Integer originalLength) {
        this.originalLength = originalLength;
    }

    public Integer getCompressedLength() {
        return compressedLength;
    }

    public void setCompressedLength(Integer compressedLength) {
        this.compressedLength = compressedLength;
    }

    public Double getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(Double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
