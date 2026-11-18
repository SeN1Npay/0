package isp.maven.repository;

import isp.maven.entity.Repairservices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairservicesRepository extends JpaRepository<Repairservices, Integer>{

}