package ru.julia.architecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julia.architecture.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
