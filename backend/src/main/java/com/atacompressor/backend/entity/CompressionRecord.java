package com.atacompressor.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "compression_records")
public class CompressionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @Column(nullable = false)
    private String originalText;

    @Lob
    private String compressedText;

    @Column(nullable = false, length = 50)
    private String taskType;

    private Integer originalLength;

    private Integer compressedLength;

    private Double compressionRatio;

    @Column(nullable = false)
    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

     public CompressionRecord() {
    }

     public long getId() {
         return id;
     }

     public void setId(long id) {
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

     public LocalDateTime getUpdatedAt() {
         return updatedAt;
     }

     public void setUpdatedAt(LocalDateTime updatedAt) {
         this.updatedAt = updatedAt;
     }
  
}
