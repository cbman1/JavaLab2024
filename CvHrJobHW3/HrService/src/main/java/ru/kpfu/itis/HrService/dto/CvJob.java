package ru.kpfu.itis.HrService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ilya Ivlev
 */


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CvJob {
  private Cv cv;
  private Job job;
}