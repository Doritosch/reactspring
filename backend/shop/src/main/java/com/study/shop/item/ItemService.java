package com.study.shop.item;

import com.study.shop.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.shop.item.ItemRepository;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItem() {
        List<Item> result = itemRepository.findAll();
        return result;
    }


    public Item findEachItem(Long id) {
        Item result = itemRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 상품이 없습니다. id" + id));

        return result;
    }
    public void saveItem(String title, Integer price, String username) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        item.setUsername(username);
        itemRepository.save(item);
    }
    public void patchItem(Long id, String title, Integer price) {
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));

        if ( !item.getTitle().equals(title) ) {
            item.setTitle(title);
        }
        if ( !item.getPrice().equals(price)) {
            item.setPrice(price);
        }

        itemRepository.save(item);
    }

    public Item deleteItem(Long id) {
        Item result = itemRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));

        itemRepository.delete(result);
        return result;
    }
}
