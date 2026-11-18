package isp.maven.repository;

import isp.maven.entity.Repairbays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairbaysRepository extends JpaRepository<Repairbays, Integer>{

}