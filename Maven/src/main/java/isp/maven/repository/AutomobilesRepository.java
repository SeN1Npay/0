package isp.maven.repository;

import isp.maven.entity.Automobiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobilesRepository extends JpaRepository<Automobiles, Integer>{

}