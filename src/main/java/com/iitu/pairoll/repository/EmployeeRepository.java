package com.iitu.pairoll.repository;

import com.iitu.pairoll.model.Employee;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    Employee getById(Long id);

    @Query(value = "select * from users u where u.name=?1 and u.age>=?2", nativeQuery = true)
    List<Employee> findByNameGreaterThan(String name, Integer age);
}
