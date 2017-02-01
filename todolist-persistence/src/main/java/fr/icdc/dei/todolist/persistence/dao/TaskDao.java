package fr.icdc.dei.todolist.persistence.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.icdc.dei.todolist.persistence.entity.Task;

public interface TaskDao extends JpaRepository<Task, Long> {

	Task findByName(String name);

	List<Task> findAllByStatusId(int id);

	List<Task> findAllByClosedDateBefore(Date date);

}
