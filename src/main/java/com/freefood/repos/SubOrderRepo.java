package com.freefood.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.freefood.entity.SubOrder;

@RepositoryRestResource(collectionResourceRel="suborder",path="suborder")
public interface SubOrderRepo extends JpaRepository<SubOrder, Integer> {

}
