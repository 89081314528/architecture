package ru.julia.architecture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.julia.architecture.entity.Task;
import ru.julia.architecture.entity.TradeOrganization;

import java.util.List;
// применен паттерн декоратор
@Service
public class TradeOrganizationServiceDecorator implements TradeOrganizationService {
    final TradeOrganizationService tradeOrganizationService;

    public TradeOrganizationServiceDecorator(TradeOrganizationService tradeOrganizationServiceImpl) {
        this.tradeOrganizationService = tradeOrganizationServiceImpl;
    }

    Logger logger = LoggerFactory.getLogger(TradeOrganizationServiceDecorator.class);

    @Override
    public void addOrganization(Integer id, String name, String contact, String manager, String contract, Integer storage) {
        logger.info("Метод начинает работать");
        tradeOrganizationService.addOrganization(id, name, contact, manager, contract, storage);
        logger.info("Метод закончил работать");
    }

    @Override
    public void deleteOrganization(Integer id) {
        logger.info("Метод начинает работать");
        tradeOrganizationService.deleteOrganization(id);
        logger.info("Метод закончил работать");
    }

    @Override
    public void updateOrganisation(Integer id, String name, String contact, String manager, String contract, Integer storage) {
        logger.info("Метод начинает работать");
        tradeOrganizationService.updateOrganisation(id, name, contact, manager, contract, storage);
        logger.info("Метод закончил работать");
    }

    @Override
    public TradeOrganization findOrganizationsById(Integer id) {
        return tradeOrganizationService.findOrganizationsById(id);
    }

    @Override
    public List<TradeOrganization> findOrganizationsByName(String name) {
        return tradeOrganizationService.findOrganizationsByName(name);
    }

    @Override
    public List<TradeOrganization> findOrganizationsByManager(String manager) {
        return tradeOrganizationService.findOrganizationsByManager(manager);
    }

    @Override
    public List<Task> findTasksByOrganization(Integer id) {
        return tradeOrganizationService.findTasksByOrganization(id);
    }

    @Override
    public List<TradeOrganization> findAll() {
        return tradeOrganizationService.findAll();
    }
}
