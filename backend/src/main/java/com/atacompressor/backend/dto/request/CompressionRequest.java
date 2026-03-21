package com.atacompressor.backend.dto.request;

public class CompressionRequest {

    private String originalText;
    private String taskType;
    private String compressionLevel;

    public CompressionRequest(){
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getCompressionLevel() {
        return compressionLevel;
    }

    public void setCompressionLevel(String compressionLevel) {
        this.compressionLevel = compressionLevel;
    }


}
