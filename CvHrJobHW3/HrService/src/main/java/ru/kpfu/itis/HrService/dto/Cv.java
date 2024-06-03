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
public class Cv {
  private String firstName;
  private String lastName;
  private String profession;
  private String city;
  private int experience;
  private List<String> stack;
  private List<String> links;
  private List<String> companies;
}
