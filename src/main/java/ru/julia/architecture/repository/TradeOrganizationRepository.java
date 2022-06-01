package ru.julia.architecture.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.julia.architecture.entity.TradeOrganization;

import java.util.List;

public interface TradeOrganizationRepository extends JpaRepository<TradeOrganization, Integer> {
    //Containing - поиск по части имени
    List<TradeOrganization> findByNameContaining(String name);
    List<TradeOrganization> findByManager(String manager);
}
