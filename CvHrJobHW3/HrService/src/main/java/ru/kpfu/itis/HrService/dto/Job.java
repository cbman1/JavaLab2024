package ru.kpfu.itis.HrService.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ilya Ivlev
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
  private String company;
  private String name;
  private String description;
  private List<String> stack;
  private int experience;
  private int salary;
}
