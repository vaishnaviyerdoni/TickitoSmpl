package com.sunbeam.tikito.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbeam.tikito.entity.EventEntity;

@Repository
public interface EventDao extends JpaRepository<EventEntity,Long> {
	  List<EventEntity> findByEventTypeIgnoreCase(String eventType);

	  
	 List<EventEntity> findByEventNameContainingIgnoreCase(String keyword);
	 
	 List<EventEntity> findByEventDurationMin(Long eventDurationMin);

}
