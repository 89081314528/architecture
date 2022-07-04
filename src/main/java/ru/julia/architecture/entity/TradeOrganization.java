package ru.julia.architecture.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "trade_organization")
@Data
//для билдера нужен конструктор со всеми аргументами
@Builder
@AllArgsConstructor
public class TradeOrganization {
    @Column(name = "org_id")
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "contact")
    private String contact;
    @Column(name = "manager")
    private String manager;
    @Column(name = "contract")
    private String contract;
    @Column(name = "storage")
    private Integer storage;
    @OneToMany(mappedBy = "tradeOrganization")
    private List<Task> tasks;

    public TradeOrganization(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeOrganization tradeOrganization = (TradeOrganization) o;
        if (id == null) {
            return false;
        }
        return Objects.equals(id, tradeOrganization.id);
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
