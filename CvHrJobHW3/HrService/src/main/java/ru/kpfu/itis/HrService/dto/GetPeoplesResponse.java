package ru.kpfu.itis.HrService.dto;

/**
 * @author Ilya Ivlev
 */

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetPeoplesResponse {
  private List<CvJob> pairs;
}