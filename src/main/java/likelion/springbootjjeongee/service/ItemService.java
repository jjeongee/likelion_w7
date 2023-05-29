package likelion.springbootjjeongee.service;

import likelion.springbootjjeongee.domain.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    public void save(Item item);

    public Item findById(Long id);

    public List<Item> findAll();
}
