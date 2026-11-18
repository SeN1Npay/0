package isp.maven.repository;

import isp.maven.entity.Repairparts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairpartsRepository extends JpaRepository<Repairparts, Integer>{

}