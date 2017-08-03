package splus.ecr.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import splus.ecr.one.model.ContainerType;

@Repository
public interface EcrContainerTypeRepository extends JpaRepository<ContainerType, Long>{

}
