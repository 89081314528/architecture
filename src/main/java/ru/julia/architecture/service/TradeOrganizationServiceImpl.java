package ru.julia.architecture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.julia.architecture.entity.Task;
import ru.julia.architecture.entity.TradeOrganization;
import ru.julia.architecture.exception.OrganizationNotFoundException;
import ru.julia.architecture.repository.TradeOrganizationRepository;

import java.util.List;

@Service
@Scope(value = "singleton") // дефолтный скоуп для всех бинов
@RequiredArgsConstructor
public class TradeOrganizationServiceImpl implements TradeOrganizationService {
    private final TradeOrganizationRepository tradeOrganizationRepository;

    //реализован паттерн builder
    @Override
    public void addOrganization(Integer id,
                                String name,
                                String contact,
                                String manager,
                                String contract,
                                Integer storage) {
        TradeOrganization tradeOrganization = TradeOrganization.builder()
                .id(id)
                .name(name)
                .contact(contact)
                .manager(manager)
                .contract(contract)
                .storage(storage)
                .build();
        tradeOrganizationRepository.save(tradeOrganization);
    }

    @Override
    public void deleteOrganization(Integer id) {
//        boolean organizationExists = tradeOrganizationRepository.existsById(id);
//        if (!organizationExists) {
//            throw new OrganizationNotFoundException();
//        } // здесь один лишний запрос к базе данных
        try {
            tradeOrganizationRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new OrganizationNotFoundException();
        }
    }

    @Override
    public void updateOrganisation(Integer id, String name, String contact, String manager,
                                   String contract, Integer storage) {
            TradeOrganization tradeOrganization = tradeOrganizationRepository.findById(id)
                    .orElseThrow(OrganizationNotFoundException::new);
        if (name != null) {
            tradeOrganization.setName(name);
        }
        if (contact != null) {
            tradeOrganization.setContact(contact);
        }
        if (manager != null) {
            tradeOrganization.setManager(manager);
        }
        if (contract != null) {
            tradeOrganization.setContract(contract);
        }
        if (storage != null) {
            tradeOrganization.setStorage(storage);
        }
        tradeOrganizationRepository.save(tradeOrganization);
    }

    @Override
    public TradeOrganization findOrganizationsById(Integer id) {
        return tradeOrganizationRepository.findById(id).orElseThrow(OrganizationNotFoundException::new);
    }

    @Override
    public List<TradeOrganization> findOrganizationsByName(String name) {
        return tradeOrganizationRepository.findByNameContaining(name);
    }

    @Override
    public List<TradeOrganization> findOrganizationsByManager(String manager) {
        return tradeOrganizationRepository.findByManager(manager);
    }

    @Override
    public List<Task> findTasksByOrganization(Integer id) {
        TradeOrganization tradeOrganization = tradeOrganizationRepository.findById(id).orElseThrow(OrganizationNotFoundException::new);
        return tradeOrganization.getTasks();
    }

    @Override
    public List<TradeOrganization> findAll() {
        return tradeOrganizationRepository.findAll();
    }
}
