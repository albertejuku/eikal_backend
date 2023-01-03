package com.eikal.service.people;

import com.eikal.models.patient.Patient;
import com.eikal.models.people.Relationship;
import com.eikal.models.people.RelationshipType;
import com.eikal.models.people.User;
import com.eikal.repository.people.RelationshipRepository;
import com.eikal.repository.people.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RelationshipRepository relationshipRepository;

    @Autowired
    public UserService(UserRepository userRepository, RelationshipRepository relationshipRepository) {
        this.userRepository = userRepository;
        this.relationshipRepository = relationshipRepository;
    }

    public User saveUser(User user) {
        user.setDateCreated(LocalDateTime.now());
        user.setDateModified(LocalDateTime.now());
//        System.out.println(user);
        return userRepository.save(user);
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Page<User> findUsers(int pageNo, int pageSize) {
        Pageable page = PageRequest.of(pageNo, pageSize);
        return userRepository.findAll(page);
    }

    public List<User> findPatientByNationalID(long nationalId) {
        return userRepository.findAllByNationalId(nationalId);
    }

    public List<User> findPatientByBirthCert(long birthCert) {
        return userRepository.findAllByBirthCertNoContaining(birthCert);
    }

    public List<User> findPatientByPhone(String phone) {
        return userRepository.findAllByPhoneContaining(phone);
    }

    public List<User> findPatientByEmail(String email) {
        return userRepository.findAllByEmailContaining(email);
    }

    public List<User> findPatientByUsername(String username) {
        return userRepository.findAllByUsernameContaining(username);
    }

    public Relationship saveRs(Map<? extends String, Object> map) {
        Relationship relationship = new Relationship();
        relationship.setUser1(new User(Long.parseLong((String) map.get("user1"))));
        relationship.setUser2(new User(Long.parseLong((String) map.get("user2"))));
        relationship.setType(RelationshipType.valueOf((String) map.get("type")));
        relationship.setDetails((String) map.get("details"));
        relationship.setIsNextOfKinOf(Long.valueOf((String) map.get("isNextOfKinOf")));
        relationship.setDateCreated(LocalDateTime.now());
        relationship.setDateModified(LocalDateTime.now());
        return relationshipRepository.save(relationship);
    }

    public Relationship findRelationship(Long id) {
        return relationshipRepository.findById(id).orElse(null);
    }

    public List<Relationship> findUserRelationships(Long userId) {
        return relationshipRepository.findAllByUser1_Id(userId);
    }

    public List<Relationship> findAllUsersNextOfKin(Long userId) {
        return relationshipRepository.findAllByIsNextOfKinOf(userId);
    }

}
