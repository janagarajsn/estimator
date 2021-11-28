package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	@Query(value = "SELECT max(task_id) + 1 FROM Task")
	public Integer max();

	@Query(value = "SELECT task_id,task_name FROM Task where techid = :techId")
	public List<Object> findTaskName(int techId);

	@Query(value = "SELECT task_id FROM Task where techid = :techId")
	public List<Integer> findTaskId(int techId);


}
