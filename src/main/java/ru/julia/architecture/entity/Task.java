package ru.julia.architecture.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task")
@Data
public class Task {
    @Column(name = "task_id")
    @Id
    private Integer id;
    @Column(name = "task")
    private String task;
    @Column(name = "result")
    private String result;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "org_id")
    private TradeOrganization tradeOrganization;

    public Task(Integer id, String task, String result, String status) {
        this.id = id;
        this.task = task;
        this.result = result;
        this.status = status;
    }

    public Task(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        if (id == null) {
            return false;
        }
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
