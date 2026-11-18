package isp.maven.repository;

import isp.maven.entity.Repairs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairsRepository extends JpaRepository<Repairs, Integer>{

}