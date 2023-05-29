package likelion.springbootjjeongee.service;

import likelion.springbootjjeongee.domain.Item;
import likelion.springbootjjeongee.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    
    @Override //매개변수 item을 부모 클래스의 메서드와 일치하도록
    @Transactional
    public Item save(Item item){
        return itemRepository.save(item);
    }

    @Override
    @Transactional(readOnly=true) //findAll로 조회한 값들 리턴
    public List<Item> findAll(){ //아이템 목록을 findAll 통해 조회
        return itemRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Item findById(Long id){
        Optional<Item> optionalItem=itemRepository.findById(id);
        if(optionalItem.isPresent()){
            return optionalItem.get();
        }
        else{
            throw new IllegalStateException("예외발생");
        }
    }

    @Override
    @Transactional
    public void update(Long id, Item item){
        Optional<Item> optionalItem=itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Item findItem = optionalItem.get();
            findItem.setBrand(item.getBrand());
            findItem.setName(item.getName());
            findItem.setPrice(item.getPrice());
            findItem.setStockQuantity(item.getStockQuantity());
        }
    }
}
