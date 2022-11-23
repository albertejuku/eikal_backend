package com.eikal.repository.places;

import com.eikal.models.places.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateDAO extends JpaRepository<State, Long> {
}
