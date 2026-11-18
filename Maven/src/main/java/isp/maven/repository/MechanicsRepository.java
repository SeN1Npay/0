package isp.maven.repository;

import isp.maven.entity.Mechanics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicsRepository extends JpaRepository<Mechanics, Integer>{

}