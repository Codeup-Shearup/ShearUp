package com.codeup.shearup.repositories;

import com.codeup.shearup.models.Service;
import com.codeup.shearup.models.User;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Long> {
//    List<Service> findServicesByUserId(long id);
//    Service findByService(String service);

}