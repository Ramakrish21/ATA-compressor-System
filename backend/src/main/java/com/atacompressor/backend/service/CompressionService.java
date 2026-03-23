package com.atacompressor.backend.service;

import com.atacompressor.backend.dto.request.CompressionRequest;
import com.atacompressor.backend.dto.response.CompressionResponse;

import java.util.*;

public interface CompressionService {

    CompressionResponse compressText(CompressionRequest request);

    List<CompressionResponse> getAllCompressions();

    CompressionResponse getCompressionById(Long id);

    void deleteCompressionById(Long id);

}
