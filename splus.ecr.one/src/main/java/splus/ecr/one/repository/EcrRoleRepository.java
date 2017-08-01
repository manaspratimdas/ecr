package splus.ecr.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import splus.ecr.one.model.Role;

public interface EcrRoleRepository extends JpaRepository<Role, Long> {

}
