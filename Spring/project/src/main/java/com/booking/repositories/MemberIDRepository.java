package com.booking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.models.MemberID;

@Repository
public interface MemberIDRepository extends CrudRepository<MemberID, Long> {
	List<MemberID> findAll();
	Optional<MemberID> findByFirstName(String firstName);
	Optional<MemberID> findByMemberId(String id);
}
