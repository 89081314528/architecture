package ru.julia.architecture.service;

import ru.julia.architecture.entity.Task;
import ru.julia.architecture.entity.TradeOrganization;

import java.util.List;

public interface TradeOrganizationService {
    void addOrganization(Integer id, String name, String contact, String manager, String contract, Integer storage);

    void deleteOrganization(Integer id);

    void updateOrganisation(Integer id, String name, String contact, String manager, String contract, Integer storage);

    TradeOrganization findOrganizationsById(Integer id);

    List<TradeOrganization>findOrganizationsByName(String name);

    List<TradeOrganization>findOrganizationsByManager(String manager);

    List<Task>findTasksByOrganization(Integer id);

    List<TradeOrganization> findAll();
}
