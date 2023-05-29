package likelion.springbootjjeongee.repository;

import likelion.springbootjjeongee.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{}



