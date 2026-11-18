package isp.maven.repository;

import isp.maven.entity.Spareparts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SparepartsRepository extends JpaRepository<Spareparts, Integer>{

}