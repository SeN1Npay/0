package isp.maven.repository;

import isp.maven.entity.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelsRepository extends JpaRepository<Models, Integer>{

}