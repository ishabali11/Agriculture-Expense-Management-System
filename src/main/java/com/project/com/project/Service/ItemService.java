package com.project.com.project.Service;

import com.project.com.project.Entity.Item;
import com.project.com.project.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item updatedItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setQuantity(updatedItem.getQuantity());
            existingItem.setPrice(updatedItem.getPrice());
            // You can update other fields as needed

            return itemRepository.save(existingItem);
        } else {
            // Item not found, handle accordingly
            throw new IllegalArgumentException("Item not found with id: " + id);
        }
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
