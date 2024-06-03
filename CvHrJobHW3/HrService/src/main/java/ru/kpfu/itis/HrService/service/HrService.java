package ru.kpfu.itis.HrService.service;

import java.util.List;

import ru.kpfu.itis.HrService.dto.CvJob;

/**
 * @author Ilya Ivlev
 */
public interface HrService {
  List<CvJob> getPairs();

}
