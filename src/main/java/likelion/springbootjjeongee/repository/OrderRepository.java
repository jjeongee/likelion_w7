package likelion.springbootjjeongee.repository;

import likelion.springbootjjeongee.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
