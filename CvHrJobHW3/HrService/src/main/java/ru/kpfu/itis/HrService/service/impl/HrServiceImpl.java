package ru.kpfu.itis.HrService.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.HrService.dto.Cv;
import ru.kpfu.itis.HrService.dto.CvJob;
import ru.kpfu.itis.HrService.dto.GetPeoplesResponse;
import ru.kpfu.itis.HrService.dto.Job;
import ru.kpfu.itis.HrService.service.HrService;

/**
 * @author Ilya Ivlev
 */

@Service
public class HrServiceImpl implements HrService {

  @GrpcClient("JobService")
  private JobServiceGrpc.JobServiceBlockingStub jobService;

  @GrpcClient("CvService")
  private CVServiceGrpc.CVServiceBlockingStub cvService;

  @Override
  public List<CvJob> getPairs() {
    List<CvJob> pairs = new ArrayList<>();

    GetPeoplesResponse jobsResponse = jobService.getAll(GetPeoplesResponse.newBuilder().build());

    List<Job> jobs = jobsResponse.getJobsList().stream().map(j -> Job.builder()
        .company(j.getCompany())
        .name(j.getName())
        .description(j.getDescription())
        .stack(j.getStackList())
        .experience(j.getExperience())
        .salary(j.getSalary())
        .build()).toList();

    GetPeoplesResponse cvsResponse = cvService.getAll(ru.itis.hrservice.grpc.pb.cv.GetAllRequest.newBuilder().build());

    List<Cv> cvs = cvsResponse.getCvsList().stream().map(c -> Cv.builder()
        .firstName(c.getFirstName())
        .lastName(c.getLastName())
        .city(c.getCity())
        .experience(c.getExperience())
        .profession(c.getProfession())
        .build()).toList();

    for (Job job : jobs) {
      for (Cv cv : cvs) {
        boolean enoughExperience = cv.getExperience() >= job.getExperience();
          if (enoughExperience) {
            pairs.add(CvJob.builder()
                .cv(cv)
                .job(job)
                .build());
          }
        }
      }
    }

    return pairs;
  }
}
