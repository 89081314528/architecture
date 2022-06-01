package ru.julia.architecture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.julia.architecture.entity.Task;
import ru.julia.architecture.entity.TradeOrganization;
import ru.julia.architecture.service.TradeOrganizationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organization")
public class TradeOrganizationController {
    private final TradeOrganizationService tradeOrganizationService;

    @PostMapping
    public void addOrganization(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String contact,
            @RequestParam String manager,
            @RequestParam String contract,
            @RequestParam Integer storage) {
        tradeOrganizationService.addOrganization(id, name, contact, manager, contract, storage);
    }

    @DeleteMapping
    public void deleteOrganization(@RequestParam Integer id) {
        tradeOrganizationService.deleteOrganization(id);
    }

    @PutMapping
    public void updateOrganisation(@RequestParam Integer id,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String contact,
                                   @RequestParam(required = false) String manager,
                                   @RequestParam(required = false) String contract,
                                   @RequestParam(required = false) Integer storage) {
        tradeOrganizationService.updateOrganisation(id, name, contact, manager, contract, storage);
    }

    @GetMapping("/byId")
    public TradeOrganization findOrganizationsById(@RequestParam Integer id) {
        return tradeOrganizationService.findOrganizationsById(id);
    }

    @GetMapping("/byName")
    public List<TradeOrganization> findOrganizationsByName(@RequestParam String name) {
        return tradeOrganizationService.findOrganizationsByName(name);
    }

    @GetMapping("/byManager")
    public List<TradeOrganization> findOrganizationsByManager(@RequestParam String manager) {
        return tradeOrganizationService.findOrganizationsByManager(manager);
    }

    @GetMapping("/tasksByOrganization")
    public List<Task> findTasksByOrganization(@RequestParam Integer id) {
        return tradeOrganizationService.findTasksByOrganization(id);
    }

    @GetMapping("/all")
    public List<TradeOrganization> findAll() {
        return tradeOrganizationService.findAll();
    }

}



